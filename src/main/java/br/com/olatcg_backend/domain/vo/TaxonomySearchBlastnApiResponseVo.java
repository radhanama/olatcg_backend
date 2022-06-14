package br.com.olatcg_backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TaxonomySearchBlastnApiResponseVo {
    @JsonProperty("process_id")
    private Long analysisId;
    private List<AlignmentWithTaxonomyBlastnVo> alignments;

    public TaxonomySearchBlastnApiResponseVo() {
    }

    public Long getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Long analysisId) {
        this.analysisId = analysisId;
    }

    public List<AlignmentWithTaxonomyBlastnVo> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<AlignmentWithTaxonomyBlastnVo> alignments) {
        this.alignments = alignments;
    }
}
