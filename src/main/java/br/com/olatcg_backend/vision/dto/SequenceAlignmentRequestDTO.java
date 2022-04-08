package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.enumerator.AlignmentTypeEnum;

public class SequenceAlignmentRequestDTO {
    private String sequenceA;
    private String sequenceB;
    private AlignmentTypeEnum type;

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

    public AlignmentTypeEnum getType() {
        return type;
    }

    public void setType(AlignmentTypeEnum type) {
        this.type = type;
    }
}
