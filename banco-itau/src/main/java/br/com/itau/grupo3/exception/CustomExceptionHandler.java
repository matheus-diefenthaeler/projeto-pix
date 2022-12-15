package br.com.itau.grupo3.exception;

import br.com.itau.grupo3.dto.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ChaveJaCadastradaBacenException.class})
    protected ResponseEntity<Object> handleChavePixCadastradaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Chave já cadastrada"), HttpStatus.CONFLICT.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
