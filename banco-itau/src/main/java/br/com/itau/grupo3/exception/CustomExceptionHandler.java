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
    @ExceptionHandler(value = {CadastroChavePixException.class})
    protected ResponseEntity<Object> handlerChavePixCadastradaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Erro ao cadastrar chave pix. Chave ou tipo já cadastrado"), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {ChaveNaoEncontradaException.class})
    protected ResponseEntity<Object> handlerChaveNaoEncontradaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Chave Pix não encontrada"), HttpStatus.NOT_FOUND.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {ContaInvalidaException.class})
    protected ResponseEntity<Object> handlerContaInvalidaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Nao foi possivel realizar a transferencia. Conta Invalida!"), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {SaldoInsuficienteException.class})
    protected ResponseEntity<Object> handlerSaldoInsuficienteException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Saldo Insuficiente!"), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {BancoNaoExistenteException.class})
    protected ResponseEntity<Object> handlerBancoNaoExistenteException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Banco nao encontrado!"), HttpStatus.NOT_FOUND.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {ConexaoComAplicacaoExternaException.class})
    protected ResponseEntity<Object> handlerConexaoComAplicacaoExternaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Erro ao tentar se comunicar com o Bacen!"), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {ContaNaoEncontradaException.class})
    protected ResponseEntity<Object> handlerContaNaoEncontradaException( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Conta nao encontrada!"), HttpStatus.NOT_FOUND.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {ContaJaCadastradaException.class})
    protected ResponseEntity<Object> handlerContaJaCadastrada( RuntimeException ex, WebRequest request) {
        CustomException exceptionDetail = new CustomException(List.of("Conta já cadastrada !"), HttpStatus.BAD_REQUEST.value());
        return handleExceptionInternal(ex, exceptionDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


}
