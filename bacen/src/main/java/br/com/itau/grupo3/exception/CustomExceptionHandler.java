package br.com.itau.grupo3.exception;

import br.com.itau.grupo3.dto.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ChavePixJaCadastradaException.class})
    protected ResponseEntity<Object> handlerChavePixCadastradaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Chave Pix já cadastrada"), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {ChavePixNaoEncontradaException.class})
    protected ResponseEntity<Object> handlerChavePixNaoEncontradaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Chave Pix não encontrada"), HttpStatus.NOT_FOUND.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {TipoChavePixJaCadastradaException.class})
    protected ResponseEntity<Object> handlerTipoChavePixJaCadastradaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Chave Pix não encontrada"), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
