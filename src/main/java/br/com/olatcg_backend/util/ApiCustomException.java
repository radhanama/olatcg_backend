package br.com.olatcg_backend.util;

import br.com.olatcg_backend.enumerator.ErrorEnum;

public class ApiCustomException extends RuntimeException {
    private ErrorEnum error;

    public ApiCustomException(ErrorEnum error) {
        this.error = error;
    }

    public ErrorEnum getError() {
        return error;
    }

    public void setError(ErrorEnum error) {
        this.error = error;
    }
}
