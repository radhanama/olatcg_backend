package br.com.olatcg_backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlignmentWithTaxonomyBlastnVo {
    @JsonProperty("sequence_description")
    private String sequenceDescription;
    @JsonProperty("input_sequence")
    private String inputAlignment;
    @JsonProperty("match_sequence")
    private String matchAlignment;


    public AlignmentWithTaxonomyBlastnVo() {
    }

    public String getSequenceDescription() {
        return sequenceDescription;
    }

    public void setSequenceDescription(String sequenceDescription) {
        this.sequenceDescription = sequenceDescription;
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
}
