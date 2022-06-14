package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Analysis;

import java.util.List;
import java.util.stream.Collectors;

public class TaxonomySearchAnalysesResponseItemDTO {
    private Long idAnalysis;
    private String status;
    private String type;
    private List<AlignmentWithTaxonomyDTO> alignments;

    public TaxonomySearchAnalysesResponseItemDTO(Analysis analysis) {
        this.idAnalysis = analysis.getId();
        this.status = analysis.getStatus().name();
        this.type = analysis.getType().name();
        this.alignments = analysis.getTaxonomies().stream()
                .map(AlignmentWithTaxonomyDTO::new).
                collect(Collectors.toList());
    }

    public Long getIdAnalysis() {
        return idAnalysis;
    }

    public void setIdAnalysis(Long idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AlignmentWithTaxonomyDTO> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<AlignmentWithTaxonomyDTO> alignments) {
        this.alignments = alignments;
    }
}
