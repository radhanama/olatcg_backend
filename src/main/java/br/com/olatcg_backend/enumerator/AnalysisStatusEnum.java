package br.com.olatcg_backend.enumerator;

public enum AnalysisStatusEnum {
    STARTED(1),
    FAILED(2),
    FINISHED(3);

    private Integer code;

    AnalysisStatusEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
