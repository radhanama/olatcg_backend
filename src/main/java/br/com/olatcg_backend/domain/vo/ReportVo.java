package br.com.olatcg_backend.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportVo {
    private String program;
    private String reference;
    private SearchTargetVo searchTarget;
    private ResultsVo results;
}
