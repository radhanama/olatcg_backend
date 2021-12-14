package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.vo.AlignmentWithTaxonomyVo;

public class AlignmentWithTaxonomyDTO {
    private String inputSequence;
    private String matchSequence;
    private String inputAlignment;
    private String taxonomy;
    private Double score;

    public AlignmentWithTaxonomyDTO(AlignmentWithTaxonomyVo vo) {
        this.inputSequence = vo.getInputSequence();
        this.matchSequence = vo.getMatchSequence();
        this.inputAlignment = vo.getInputAlignment();
        this.taxonomy = vo.getTaxonomy();
        this.score = vo.getScore();
    }

    public String getInputSequence() {
        return inputSequence;
    }

    public void setInputSequence(String inputSequence) {
        this.inputSequence = inputSequence;
    }

    public String getMatchSequence() {
        return matchSequence;
    }

    public void setMatchSequence(String matchSequence) {
        this.matchSequence = matchSequence;
    }

    public String getInputAlignment() {
        return inputAlignment;
    }

    public void setInputAlignment(String inputAlignment) {
        this.inputAlignment = inputAlignment;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
