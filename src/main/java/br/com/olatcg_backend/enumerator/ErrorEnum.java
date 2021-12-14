package br.com.olatcg_backend.enumerator;

public enum ErrorEnum {
    GENERAL_ERROR(0),
    INVALID_CHARACTERS_IN_SEQUENCE_FILE(100),
    INVALID_SEQUENCE_FILE_TYPE(101),
    TAXONOMY_SEARCH_API_ERROR(102);

    private Integer errorCode;

    ErrorEnum(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
