package br.com.olatcg_backend.vision.geral;

import br.com.olatcg_backend.service.TaxonomySearchService;
import br.com.olatcg_backend.util.Routes;
import br.com.olatcg_backend.vision.dto.SequenceFileDTO;
import br.com.olatcg_backend.vision.dto.TaxonomyNameResponseDTO;
import br.com.olatcg_backend.vision.dto.TaxonomySearchAnalysesResponseDTO;
import br.com.olatcg_backend.vision.dto.TaxonomySearchResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxonomySearchController {

    @Autowired
    private TaxonomySearchService taxonomySearchService;

    @GetMapping(Routes.TAXONOMY_SEARCH_API + "/search")
    public TaxonomySearchAnalysesResponseDTO search(){
        return taxonomySearchService.search();
    }

    @GetMapping(Routes.TAXONOMY_SEARCH_API + "/getTaxonomyNameFromSequenceId")
    public TaxonomyNameResponseDTO getTaxonomyNameFrom(@RequestParam("sequenceId") Long bioSeqId){
        return taxonomySearchService.findNameFrom(bioSeqId);
    }

    @PostMapping(Routes.TAXONOMY_SEARCH_API + "/getTaxonomyFromSequences")
    public TaxonomySearchResponseDTO getTaxonomyFrom(@RequestBody SequenceFileDTO dto){
        return taxonomySearchService.searchTaxonomyFrom(dto);
    }
}
