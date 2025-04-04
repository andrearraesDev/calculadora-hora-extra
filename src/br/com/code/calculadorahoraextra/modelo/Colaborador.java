package br.com.code.calculadorahoraextra.modelo;

public class Colaborador {
    private final String nome;
    private final double salarioMensal;
    private final double horasExtrasTrabalhadas;

    public Colaborador(String nome, double salarioMensal, double horasExtrasTrabalhadas) {
        this.nome = nome;
        this.salarioMensal = salarioMensal;
        this.horasExtrasTrabalhadas = horasExtrasTrabalhadas;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public double getHorasExtrasTrabalhadas() {
        return horasExtrasTrabalhadas;
    }
}