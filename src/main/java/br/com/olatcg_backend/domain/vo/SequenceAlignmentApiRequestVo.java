package br.com.olatcg_backend.domain.vo;

import br.com.olatcg_backend.vision.dto.SequenceAlignmentRequestDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SequenceAlignmentApiRequestVo {
    @JsonProperty("sequence_a")
    private String sequenceA;
    @JsonProperty("sequence_b")
    private String sequenceB;
    @JsonProperty("match_score")
    private Integer matchScore;
    @JsonProperty("mismatch_score")
    private Integer mismatchScore;
    private String type;
    @JsonProperty("get_first")
    private Boolean getFirst = true;

    public SequenceAlignmentApiRequestVo(SequenceAlignmentRequestDTO dto) {
        this.sequenceA = dto.getSequenceA();
        this.sequenceB = dto.getSequenceB();
        this.matchScore = dto.getMatchScore();
        this.mismatchScore = dto.getMismatchScore();
        this.type = dto.getAlignmentType().name();
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
