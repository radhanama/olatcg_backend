package br.com.olatcg_backend.enumerator;

public enum SupportedApiDatabases {
    OLATCGDB(1);

    private Integer code;

    SupportedApiDatabases(Integer code) {
        this.code = code;
    }
}
