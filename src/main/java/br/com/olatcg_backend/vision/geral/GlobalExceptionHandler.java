package br.com.olatcg_backend.vision.geral;

import br.com.olatcg_backend.util.CustomException;
import br.com.olatcg_backend.vision.dto.ErrorDefaultResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    @RequestMapping("/dataError")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDefaultResponseDTO exceptionHandler(CustomException ex){
        return new ErrorDefaultResponseDTO(ex.getErrorEnum());
    }
}
