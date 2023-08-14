package br.com.olatcg_backend.domain.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnalysisStatusEnum {
    STARTED(1, "STARTED"),
    FAILED(2, "FAILED"),
    FINISHED(3, "FINISHED");

    private Integer code;
    private String value;

}
