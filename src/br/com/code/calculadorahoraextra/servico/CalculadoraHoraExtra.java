package br.com.code.calculadorahoraextra.servico;

import br.com.code.calculadorahoraextra.modelo.Colaborador;

public class CalculadoraHoraExtra {
    private static final int HORAS_MES = 220;
    private static final double BONUS_HORA_EXTRA = 1.5;

    public static double calcularValorHoraNormal(double salario) {
        return salario / HORAS_MES;
    }

    public static double calcularValorHoraExtra(double valorHora) {
        return valorHora * BONUS_HORA_EXTRA;
    }

    public static double calcularTotalHoraExtra(Colaborador c) {
        double horaNormal = calcularValorHoraNormal(c.getSalarioMensal());
        double horaExtra = calcularValorHoraExtra(horaNormal);
        return horaExtra * c.getHorasExtrasTrabalhadas();
    }
}