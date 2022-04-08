package br.com.olatcg_backend.enumerator;

public enum AlignmentTypeEnum {
    GLOBAL(1),
    LOCAL(2);

    private Integer code;

    AlignmentTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
