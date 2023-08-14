package br.com.olatcg_backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HspVo {
    private int num;
    @JsonProperty("bit_score")
    private double bitScore;
    private int score;
    private double evalue;
    private int identity;
    @JsonProperty("query_from")
    private int queryFrom;
    @JsonProperty("query_to")
    private int queryTo;
    @JsonProperty("query_strand")
    private String queryStrand;
    @JsonProperty("hit_from")
    private int hitFrom;
    @JsonProperty("hit_to")
    private int hitTo;
    @JsonProperty("hit_strand")
    private String hitStrand;
    @JsonProperty("align_len")
    private int alignLen;
    private int gaps;
    private String qseq;
    private String hseq;
    private String midline;
}
