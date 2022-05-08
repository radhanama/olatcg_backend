package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Taxonomy;

import java.util.List;
import java.util.stream.Collectors;

public class TaxonomySearchResponseDTO {
    private Long idAnalysis;
    private List<AlignmentWithTaxonomyDTO> alignments;

    public TaxonomySearchResponseDTO(List<Taxonomy> taxonomies) {
        this.idAnalysis = taxonomies.get(0).getAnalysis().getId();
        this.alignments = taxonomies.stream().map(tax -> new AlignmentWithTaxonomyDTO(tax)).collect(Collectors.toList());
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
