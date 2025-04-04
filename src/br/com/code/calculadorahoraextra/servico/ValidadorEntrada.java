package br.com.code.calculadorahoraextra.servico;

import br.com.code.calculadorahoraextra.excecao.EntradaInvalidaException;

public class ValidadorEntrada {
    public static void validarNome(String nome) throws EntradaInvalidaException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new EntradaInvalidaException("Nome do colaborador não pode ser vazio.");
        }
    }

    public static void validarSalario(double salario) throws EntradaInvalidaException {
        if (salario <= 0) {
            throw new EntradaInvalidaException("Salário deve ser maior que zero.");
        }
    }

    public static void validarHorasExtras(double horas) throws EntradaInvalidaException {
        if (horas < 0) {
            throw new EntradaInvalidaException("Horas extras não podem ser negativas.");
        }
    }
}