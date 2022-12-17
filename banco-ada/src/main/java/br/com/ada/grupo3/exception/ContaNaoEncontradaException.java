package br.com.ada.grupo3.exception;

public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException() {
    }

    public ContaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
