package br.com.olatcg_backend.exception;

public class MapperException extends RuntimeException {
    public MapperException(String message) {
        super("A mapper exception occurred: " + message);
    }
}
