package br.com.olatcg_backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlignmentWithTaxonomyVo {
    @JsonProperty("input_sequence")
    private String inputSequence;
    @JsonProperty("match_sequence")
    private String matchSequence;
    @JsonProperty("input_alignment")
    private String inputAlignment;
    @JsonProperty("match_alignment")
    private String matchAlignment;
    private String taxonomy;
    private Double score;

    public AlignmentWithTaxonomyVo() {
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

    public String getMatchAlignment() {
        return matchAlignment;
    }

    public void setMatchAlignment(String matchAlignment) {
        this.matchAlignment = matchAlignment;
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
