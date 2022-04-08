package br.com.olatcg_backend.data.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SequenceAlignmentApiResponseVo {
    @JsonProperty("alignment_a")
    private String alignmentA;
    @JsonProperty("alignment_b")
    private String alignmentB;
    private Double score;

    public String getAlignmentA() {
        return alignmentA;
    }

    public void setAlignmentA(String alignmentA) {
        this.alignmentA = alignmentA;
    }

    public String getAlignmentB() {
        return alignmentB;
    }

    public void setAlignmentB(String alignmentB) {
        this.alignmentB = alignmentB;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
