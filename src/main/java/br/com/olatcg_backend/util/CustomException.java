package br.com.olatcg_backend.util;

import br.com.olatcg_backend.enumerator.ErrorEnum;

public class CustomException extends Throwable {
    private ErrorEnum errorEnum;

    public CustomException(ErrorEnum erro) {
        this.errorEnum = erro;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
}
