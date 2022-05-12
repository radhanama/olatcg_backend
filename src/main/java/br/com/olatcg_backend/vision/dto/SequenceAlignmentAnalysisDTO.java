package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.domain.Alignment;

public class SequenceAlignmentAnalysisDTO {
    private Long idAnalysis;
    private String status;
    private String alignmentA;
    private String alignmentB;
    private String type;
    private Double score;

    public SequenceAlignmentAnalysisDTO(Alignment alignment) {
        this.idAnalysis = alignment.getAnalysis().getId();
        this.status = alignment.getAnalysis().getStatus().name();
        this.alignmentA = alignment.getInputAlignment();
        this.alignmentB = alignment.getMatchAlignment();
        this.type = alignment.getType();
        this.score = alignment.getScore();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
