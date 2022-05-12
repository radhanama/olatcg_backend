package br.com.olatcg_backend.enumerator;

public enum AnalysisTypeEnum {
    ALIGNMENT(1),
    TAXONOMY(2);

    private Integer code;

    AnalysisTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
