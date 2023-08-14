package br.com.olatcg_backend.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultsVo {
    private SearchVo search;
    private StatVo stat;
    private String message;
}
