package br.com.olatcg_backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatVo {
    @JsonProperty("db_num")
    private int dbNum;
    @JsonProperty("db_len")
    private int dbLen;
    @JsonProperty("hsp_len")
    private int hspLen;
    @JsonProperty("eff_space")
    private int effSpace;
    private double kappa;
    private double lambda;
    private double entropy;
}
