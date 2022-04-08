package br.com.olatcg_backend.domain.vo;

import br.com.olatcg_backend.vision.dto.SequenceAlignmentRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SequenceAlignmentApiRequestVo {
    @JsonProperty("sequence_a")
    private String sequenceA;
    @JsonProperty("sequence_b")
    private String sequenceB;
    private String type;
    @JsonProperty("get_first")
    private Boolean getFirst = true;

    public SequenceAlignmentApiRequestVo(SequenceAlignmentRequestDTO dto) {
        this.sequenceA = dto.getSequenceA();
        this.sequenceB = dto.getSequenceB();
        this.type = dto.getType().name();
        this.getFirst = true;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getGetFirst() {
        return getFirst;
    }

    public void setGetFirst(Boolean getFirst) {
        this.getFirst = getFirst;
    }
}
