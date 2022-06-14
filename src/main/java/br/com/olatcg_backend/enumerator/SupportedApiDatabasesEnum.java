package br.com.olatcg_backend.enumerator;

public enum SupportedApiDatabasesEnum {
    OLATCGDB(1),
    NCBI_NT(2);

    private Integer code;

    SupportedApiDatabasesEnum(Integer code) {
        this.code = code;
    }
}
