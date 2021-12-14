package br.com.olatcg_backend.vision.geral;

import br.com.olatcg_backend.service.TaxonomySearchService;
import br.com.olatcg_backend.util.Routes;
import br.com.olatcg_backend.vision.dto.SequenceFileDTO;
import br.com.olatcg_backend.vision.dto.TaxonomySearchResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxonomySearchController {

    @Autowired
    private TaxonomySearchService taxonomySearchService;

    @GetMapping(Routes.TAXONOMY_SEARCH_API + "/getTaxonomyFromSequences")
    public TaxonomySearchResponseDTO getTaxonomyFrom(@RequestBody SequenceFileDTO dto){
        return taxonomySearchService.searchTaxonomyFrom(dto);
    }
}
