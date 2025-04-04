package br.com.code.calculadorahoraextra.aplicacao;

import java.util.Scanner;

import br.com.code.calculadorahoraextra.excecao.EntradaInvalidaException;
import br.com.code.calculadorahoraextra.modelo.Colaborador;
import br.com.code.calculadorahoraextra.servico.CalculadoraHoraExtra;
import br.com.code.calculadorahoraextra.servico.ValidadorEntrada;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exibirCabecalho();

        try {
            System.out.print("👤 Nome do colaborador: ");
            String nome = scanner.nextLine();
            ValidadorEntrada.validarNome(nome);

            System.out.print("💰 Salário mensal (R$): ");
            double salario = scanner.nextDouble();
            ValidadorEntrada.validarSalario(salario);

            System.out.print("⏱️ Horas extras trabalhadas: ");
            double horas = scanner.nextDouble();
            ValidadorEntrada.validarHorasExtras(horas);

            Colaborador colaborador = new Colaborador(nome, salario, horas);
            double total = CalculadoraHoraExtra.calcularTotalHoraExtra(colaborador);

            exibirResumo(colaborador, total);

        } catch (EntradaInvalidaException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida. Tente novamente.");
        } finally {
            scanner.close();
            exibirRodape();
        }
    }

    static void exibirCabecalho() {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║       SISTEMA DE CÁLCULO DE HORA EXTRA - RH        ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");
    }

    static void exibirResumo(Colaborador c, double totalHoraExtra) {
        double valorHora = CalculadoraHoraExtra.calcularValorHoraNormal(c.getSalarioMensal());
        double valorExtra = CalculadoraHoraExtra.calcularValorHoraExtra(valorHora);
        double salarioFinal = c.getSalarioMensal() + totalHoraExtra;

        System.out.println("\n📋 RESUMO:");
        System.out.printf("👤 Colaborador: %s%n", c.getNome());
        System.out.printf("💼 Salário mensal: R$ %.2f%n", c.getSalarioMensal());
        System.out.printf("🕒 Valor da hora normal: R$ %.2f%n", valorHora);
        System.out.printf("➕ Valor da hora extra (50%%): R$ %.2f%n", valorExtra);
        System.out.printf("⏱️ Horas extras trabalhadas: %.1f horas%n", c.getHorasExtrasTrabalhadas());
        System.out.printf("💵 Total em horas extras: R$ %.2f%n", totalHoraExtra);
        System.out.printf("💰 Salário total com horas extras: R$ %.2f%n", salarioFinal);
    }

    static void exibirRodape() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📎 Desenvolvido por André Arraes");
        System.out.println("🔗 github.com/andrearraesDev/calculadora-hora-extra");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
}