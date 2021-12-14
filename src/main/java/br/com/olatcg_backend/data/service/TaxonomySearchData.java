package br.com.olatcg_backend.data.service;

import br.com.olatcg_backend.data.ITaxonomySearchData;
import br.com.olatcg_backend.domain.vo.TaxonomySeachApiRequestVo;
import br.com.olatcg_backend.domain.vo.TaxonomySearchApiResponseVo;
import br.com.olatcg_backend.enumerator.ErrorEnum;
import br.com.olatcg_backend.util.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class TaxonomySearchData implements ITaxonomySearchData {
    @Value("${api.olatcg.basePath}")
    private String apiBasePath;

    @Value("${api.olatcg.taxonomySearch.servicePath}")
    private String taxonomySearchServicePath;

    private WebClient client;

    private void prepareRequest(String serviceUrl){
        this.client = WebClient.builder()
                .baseUrl(this.apiBasePath)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public TaxonomySearchApiResponseVo obtainTaxonomyFrom(TaxonomySeachApiRequestVo vo) throws CustomException {
        prepareRequest(this.taxonomySearchServicePath);
        Mono<ResponseEntity<TaxonomySearchApiResponseVo>> response = this.client
                .method(HttpMethod.GET)
                .uri(this.taxonomySearchServicePath)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(vo), TaxonomySeachApiRequestVo.class)
                .retrieve()
                .toEntity(TaxonomySearchApiResponseVo.class);
        if(response.block().getStatusCode() != HttpStatus.OK) {
            throw new CustomException(ErrorEnum.TAXONOMY_SEARCH_API_ERROR);
        }
        return response.block().getBody();
    }
}
