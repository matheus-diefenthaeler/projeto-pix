package br.com.itau.grupo3.exception;

public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException() {
    }

    public ContaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
