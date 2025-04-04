package br.com.code.calculadorahoraextra.excecao;

public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}