package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.enumerator.AlignmentTypeEnum;

public class SequenceAlignmentRequestDTO {
    private String sequenceA;
    private String sequenceB;
    private Integer matchScore;
    private Integer mismatchScore;
    private AlignmentTypeEnum alignmentType;

    public String getSequenceA() {
        return sequenceA;
    }

    public void setSequenceA(String sequenceA) {
        this.sequenceA = sequenceA;
    }

    public String getSequenceB() {
        return sequenceB;
    }

    public void setSequenceB(String sequenceB) {
        this.sequenceB = sequenceB;
    }

    public Integer getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Integer matchScore) {
        this.matchScore = matchScore;
    }

    public Integer getMismatchScore() {
        return mismatchScore;
    }

    public void setMismatchScore(Integer mismatchScore) {
        this.mismatchScore = mismatchScore;
    }

    public AlignmentTypeEnum getAlignmentType() {
        return alignmentType;
    }

    public void setAlignmentType(AlignmentTypeEnum alignmentType) {
        this.alignmentType = alignmentType;
    }
}
