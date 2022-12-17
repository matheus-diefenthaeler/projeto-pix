package br.com.ada.grupo3.exception;

public class ContaInvalidaException extends RuntimeException {
    public ContaInvalidaException(){}
    public ContaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
