package br.com.olatcg_backend.vision.dto;

import br.com.olatcg_backend.enumerator.ErrorEnum;

public class ErrorDefaultResponseDTO {
    private Integer errorCode;
    private String errorDescription;

    public ErrorDefaultResponseDTO() {
    }

    public ErrorDefaultResponseDTO(ErrorEnum erro) {
        this.setErrorCode(erro.getErrorCode());
        this.setErrorDescription(erro.name());
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
