package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.enumerator.ErrorEnum;

public class ErrorDefaultResponseDTO {
    private String error;
    private Integer errorCode;
    private String errorDescription;

    public ErrorDefaultResponseDTO() {
    }

    public ErrorDefaultResponseDTO(ErrorEnum error) {
        this.setError(error.name());
        this.setErrorCode(error.getErrorCode());
        this.setErrorDescription(error.name());
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
