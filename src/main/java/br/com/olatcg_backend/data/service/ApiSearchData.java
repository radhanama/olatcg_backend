package br.com.olatcg_backend.data.service;

import br.com.olatcg_backend.data.IPhylogenySearchData;
import br.com.olatcg_backend.data.ISequenceAlignmentData;
import br.com.olatcg_backend.data.ITaxonomySearchData;
import br.com.olatcg_backend.domain.vo.SequenceAlignmentApiRequestVo;
import br.com.olatcg_backend.domain.vo.PhylogenyApiRequestVo;
import br.com.olatcg_backend.domain.vo.TaxonomySeachApiRequestVo;
import br.com.olatcg_backend.domain.vo.TaxonomySearchApiResponseVo;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.util.ApiCustomException;
import br.com.olatcg_backend.util.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

@Repository
public class ApiSearchData implements ITaxonomySearchData, IPhylogenySearchData, ISequenceAlignmentData {
    @Value("${api.olatcg.basePath}")
    private String apiBasePath;

    @Value("${api.olatcg.taxonomySearch.servicePath}")
    private String taxonomySearchServicePath;

    @Value("${api.olatcg.phylogeny.servicePath}")
    private String phylogenySearchServicePath;

    @Value("${api.olatcg.sequenceAlignment.servicePath}")
    private String sequenceAlignmentServicePath;

    private WebClient.RequestBodySpec clientBodySpec;

    private static final Pattern patternDataFromUrl = Pattern.compile("(\\\\n|\"|\\\\)");

    private static ExchangeFilterFunction handleApiErrors()  {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            if (clientResponse.statusCode() == HttpStatus.SERVICE_UNAVAILABLE) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new ApiCustomException(ErrorEnum.REQUEST_TIMEOUT_EXCEPTION)));
            } else if (clientResponse.statusCode().isError()) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new ApiCustomException(ErrorEnum.REQUEST_GENERAL_ERROR)));
            } else {
                return Mono.just(clientResponse);
            }
        });
    }

    private void prepareRequest(HttpMethod httpVerb, String uri){
        this.clientBodySpec = WebClient.builder()
                .filter(handleApiErrors())
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                    .defaultCodecs()
                                    .maxInMemorySize(16 * 24 * 24 * 1024))
                        .build())
                .baseUrl(this.apiBasePath)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .method(httpVerb)
                .uri(uri);
    }

    @Override
    public TaxonomySearchApiResponseVo obtainTaxonomyFrom(TaxonomySeachApiRequestVo vo) throws CustomException, ApiCustomException {
        try{
            prepareRequest(HttpMethod.GET, taxonomySearchServicePath);
            Mono<ResponseEntity<TaxonomySearchApiResponseVo>> response = this.clientBodySpec
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(Mono.just(vo), TaxonomySeachApiRequestVo.class)
                    .retrieve()
                    .toEntity(TaxonomySearchApiResponseVo.class);
            if(response.block().getStatusCode() != HttpStatus.OK) {
                throw new CustomException(ErrorEnum.TAXONOMY_SEARCH_API_ERROR);
            }
            return response.block().getBody();
        } catch (ApiCustomException ex){
            throw new CustomException(ex.getError());
        }
    }

    @Override
    public String obtainNewickFormatFrom(PhylogenyApiRequestVo vo) throws CustomException, ApiCustomException {
        try {
            prepareRequest(HttpMethod.GET, phylogenySearchServicePath);
            Mono<ResponseEntity<String>> response = this.clientBodySpec
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(Mono.just(vo), PhylogenyApiRequestVo.class)
                    .retrieve()
                    .toEntity(String.class);
            if(response.block().getStatusCode() != HttpStatus.OK) {
                throw new CustomException(ErrorEnum.PHYLOGENY_API_ERROR);
            }
            return response.block().getBody().replaceAll("\n|\"|\\\\", "");
        } catch (ApiCustomException ex){
            throw new ApiCustomException(ex.getError());
        }
    }

    @Override
    public SequenceAlignmentApiResponseVo align(SequenceAlignmentApiRequestVo vo) throws CustomException, ApiCustomException {
        try {
            prepareRequest(HttpMethod.GET, sequenceAlignmentServicePath);
            Mono<ResponseEntity<SequenceAlignmentApiResponseVo>> response = this.clientBodySpec
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(Mono.just(vo), SequenceAlignmentApiRequestVo.class)
                    .retrieve()
                    .toEntity(SequenceAlignmentApiResponseVo.class);
            if(response.block().getStatusCode() != HttpStatus.OK) {
                throw new CustomException(ErrorEnum.SEQUENCE_ALIGNMENT_API_ERROR);
            }
            return response.block().getBody();
        } catch (ApiCustomException ex){
            throw new ApiCustomException(ex.getError());
        }
    }
}
