package br.com.olatcg_backend.vision.geral;

import br.com.olatcg_backend.domain.vo.TaxonomySearchBlastnApiResponseVo;
import br.com.olatcg_backend.service.TaxonomySearchService;
import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.util.ProcessingHandlerUtils;
import br.com.olatcg_backend.util.Routes;
import br.com.olatcg_backend.vision.dto.PreProcessingSearchTaxonomyFromSequenceDTO;
import br.com.olatcg_backend.vision.dto.PreProcessingSearchTaxonomyFromSequenceFileDTO;
import br.com.olatcg_backend.vision.dto.RequestTimeoutResponseDTO;
import br.com.olatcg_backend.vision.dto.SequenceFileDTO;
import br.com.olatcg_backend.vision.dto.TaxonomyNameResponseDTO;
import br.com.olatcg_backend.vision.dto.TaxonomySearchAnalysesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TaxonomySearchController {

    @Autowired
    private TaxonomySearchService taxonomySearchService;

    @Autowired
    private ProcessingHandlerUtils processingHandlerUtils;

    @GetMapping(Routes.TAXONOMY_SEARCH_API + "/search")
    public TaxonomySearchAnalysesResponseDTO search(){
        return taxonomySearchService.search();
    }

    @GetMapping(Routes.TAXONOMY_SEARCH_API + "/getTaxonomyNameFromSequenceId")
    public TaxonomyNameResponseDTO getTaxonomyNameFrom(@RequestParam("sequenceId") Long bioSeqId){
        return taxonomySearchService.findNameFrom(bioSeqId);
    }

    @PostMapping(Routes.TAXONOMY_SEARCH_API + "/getTaxonomyFromSequences")
    public ResponseEntity<?> getTaxonomyFrom(@RequestBody SequenceFileDTO dto) throws CustomException {
        PreProcessingSearchTaxonomyFromSequenceFileDTO preProcessingResult = taxonomySearchService.preProcessingSearchTaxonomyFrom(dto);
        RequestTimeoutResponseDTO timeoutBodyResp = new RequestTimeoutResponseDTO(preProcessingResult.getProcessingAnalysis().getId());
        taxonomySearchService.searchTaxonomyFrom(preProcessingResult);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new RequestTimeoutResponseDTO(timeoutBodyResp.getIdAnalysis()));

        /**
        return processingHandlerUtils.respondAccordingProccessTime(
                timeoutBodyResp,
                result -> {
                    TaxonomySearchResponseDTO taxonomySearchResponseDTO = new TaxonomySearchResponseDTO();
                    try {
                        taxonomySearchResponseDTO = taxonomySearchService.searchTaxonomyFrom((PreProcessingSearchTaxonomyFromSequenceFileDTO) result);
                    } catch (CustomException e) {
                        LOG.info(e.getErrorEnum().name());
                    }
                    return taxonomySearchResponseDTO;
                },
                preProcessingResult
        );
         **/
    }

    @PostMapping(Routes.TAXONOMY_SEARCH_API + "/getTaxonomyFromSequence")
    public ResponseEntity<?> getTaxonomyFrom(@RequestBody String sequence) throws CustomException {
        PreProcessingSearchTaxonomyFromSequenceDTO preProcessingResult = taxonomySearchService.preProcessingSearchTaxonomyFrom(sequence);
        RequestTimeoutResponseDTO timeoutBodyResp = new RequestTimeoutResponseDTO(preProcessingResult.getAnalysis().getId());
        taxonomySearchService.searchTaxonomyFrom(preProcessingResult);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new RequestTimeoutResponseDTO(timeoutBodyResp.getIdAnalysis()));
    }

    @PostMapping(Routes.TAXONOMY_SEARCH_API + "/saveTaxonomyFromSequenceResult")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTaxonomyFromSequenceResult(@RequestBody TaxonomySearchBlastnApiResponseVo vo) throws CustomException {
        taxonomySearchService.saveTaxonomyFromSequenceResult(vo);
    }
}
