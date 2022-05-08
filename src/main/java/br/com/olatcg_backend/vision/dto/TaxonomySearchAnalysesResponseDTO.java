package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Analysis;

import java.util.List;
import java.util.stream.Collectors;

public class TaxonomySearchAnalysesResponseDTO {
    private List<TaxonomySearchAnalysesResponseItemDTO> taxonomySearchRecords;

    public TaxonomySearchAnalysesResponseDTO(List<Analysis> allTaxonomyAnalyzes) {
        this.taxonomySearchRecords = allTaxonomyAnalyzes.stream()
                .map(TaxonomySearchAnalysesResponseItemDTO::new)
                .collect(Collectors.toList());
    }

    public List<TaxonomySearchAnalysesResponseItemDTO> getTaxonomySearchRecords() {
        return taxonomySearchRecords;
    }

    public void setTaxonomySearchRecords(List<TaxonomySearchAnalysesResponseItemDTO> taxonomySearchRecords) {
        this.taxonomySearchRecords = taxonomySearchRecords;
    }
}
