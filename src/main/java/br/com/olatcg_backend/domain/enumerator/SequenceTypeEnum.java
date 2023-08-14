package br.com.olatcg_backend.domain.enumerator;

public enum SequenceTypeEnum {
    DNA(1);

    private Integer code;

    SequenceTypeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
