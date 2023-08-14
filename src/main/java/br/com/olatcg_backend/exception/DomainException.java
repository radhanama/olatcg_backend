package br.com.olatcg_backend.exception;

public class DomainException extends RuntimeException{
    public DomainException(String message){
        super("A domain exception occurred: " + message);
    }
}
