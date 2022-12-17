package br.com.itau.grupo3.exception;

public class ContaInvalidaException extends RuntimeException {
    public ContaInvalidaException(){}
    public ContaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
