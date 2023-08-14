package br.com.olatcg_backend.domain.enumerator;

public enum AnalysisTypeEnum {
    ALIGNMENT(1),
    HOMOLOGY(2),
    TAXONOMY_BLAST(3);

    private Integer code;

    AnalysisTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
