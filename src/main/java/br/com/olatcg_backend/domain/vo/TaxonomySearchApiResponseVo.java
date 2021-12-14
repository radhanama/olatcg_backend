package br.com.olatcg_backend.domain.vo;

import java.util.List;

public class TaxonomySearchApiResponseVo {
    private List<AlignmentWithTaxonomyVo> alignments;

    public TaxonomySearchApiResponseVo() {
    }

    public TaxonomySearchApiResponseVo(List<AlignmentWithTaxonomyVo> alignments) {
        this.alignments = alignments;
    }

    public List<AlignmentWithTaxonomyVo> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<AlignmentWithTaxonomyVo> alignments) {
        this.alignments = alignments;
    }
}
