package br.com.olatcg_backend.enumerator;

public enum ErrorEnum {
    GENERAL_ERROR(1),
    INVALID_FILE_TYPE(100),
    INVALID_CHARACTERS_IN_SEQUENCE_FILE_ERROR(101),
    DECODE_FILE_ERROR(102),
    TAXONOMY_SEARCH_API_ERROR(103),
    CONVERT_TAXONOMY_SEARCH_API_RESPONSE_TO_TAXONOMY_ERROR(104),
    PHYLOGENY_API_ERROR(104),
    PERSISTENCE_DATABASE_ERROR(105);

    private Integer errorCode;

    ErrorEnum(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
