package br.com.olatcg_backend.enumerator;

public enum SupportedFileType {
    TEXT(1);

    private Integer code;

    SupportedFileType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
