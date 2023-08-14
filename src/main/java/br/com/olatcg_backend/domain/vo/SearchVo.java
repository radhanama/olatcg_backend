package br.com.olatcg_backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchVo {
    @JsonProperty("query_id")
    private String queryId;
    @JsonProperty("query_title")
    private String queryTitle;
    @JsonProperty("query_len")
    private int queryLen;
    private List<HitVo> hitVos;
}
