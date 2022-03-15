package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Analysis;

import java.util.List;
import java.util.stream.Collectors;

public class TaxonomySearchAnalysesResponseItemDTO {
    private Long idAnalysis;
    private List<AlignmentWithTaxonomyDTO> alignments;

    public TaxonomySearchAnalysesResponseItemDTO(Analysis analysis) {
        this.idAnalysis = analysis.getId();
        this.alignments = analysis.getTaxonomies().stream()
                .map(tax -> new AlignmentWithTaxonomyDTO(tax)).
                collect(Collectors.toList());
    }

    public Long getIdAnalysis() {
        return idAnalysis;
    }

    public void setIdAnalysis(Long idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public List<AlignmentWithTaxonomyDTO> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<AlignmentWithTaxonomyDTO> alignments) {
        this.alignments = alignments;
    }
}
