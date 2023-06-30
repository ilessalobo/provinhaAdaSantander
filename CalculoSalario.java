package bonitinho;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculoSalario {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double[] salariosLiquidos = new double[5];
		double[] salariosBrutos = new double[5];
		double totalInss = 0;
		double totalImpRenda = 0;

		for (int i = 0; i < 5; i++) {
			System.out.print("Valor do salário bruto do funcionário " + (i + 1) + ": ");
			double salarioBruto = scanner.nextDouble();
			double inss = calculoDoInss(salarioBruto);
			double impostoRenda = calcularImpostoRenda(salarioBruto);
			double salarioLiquido = calculoDoSalarioLiquido(salarioBruto);

			salariosBrutos[i] = salarioBruto;
			salariosLiquidos[i] = salarioLiquido;
			totalInss += inss;
			totalImpRenda += impostoRenda;
		}

		DecimalFormat deciFormt = new DecimalFormat("0.00");
		System.out.println("\nSaida do programa:");

		for (int i = 0; i < 5; i++) {
			System.out.println("\nFuncionário " + (i + 1) + ":");
			System.out.println("Salário bruto: R$" + deciFormt.format(salariosBrutos[i]));
			System.out.println("Quanto pagou ao INSS: R$" + deciFormt.format(calculoDoInss(salariosBrutos[i])));
			System.out.println("Quanto pagou de Imposto de Renda: R$" + deciFormt.format(calcularImpostoRenda(salariosBrutos[i])));
			System.out.println("Salário líquido: R$" + deciFormt.format(salariosLiquidos[i]));
		}
	}

	public static double calculoDoInss(double salarioBruto) {
		double desconto;
		if (salarioBruto <= 1212.00) {
			desconto = salarioBruto * 0.075;
		} else if (salarioBruto <= 2427.35) {
			desconto = salarioBruto * 0.09;
		} else if (salarioBruto <= 3641.03) {
			desconto = salarioBruto * 0.12;
		} else {
			desconto = salarioBruto * 0.14;
		}
		return desconto;
	}

	public static double calcularImpostoRenda(double salarioBruto) {
		double desconto;
		if (salarioBruto <= 1903.98) {
			desconto = 0;
		} else if (salarioBruto <= 2826.65) {
			desconto = salarioBruto * 0.075;
		} else if (salarioBruto <= 3751.05) {
			desconto = salarioBruto * 0.15;
		} else if (salarioBruto <= 4664.68) {
			desconto = salarioBruto * 0.225;
		} else {
			desconto = salarioBruto * 0.275;
		}
		return desconto;
	}

	public static double calculoDoSalarioLiquido(double salarioBruto) {
		double inss = calculoDoInss(salarioBruto);
		double impostoRenda = calcularImpostoRenda(salarioBruto);
		double salarioLiquido = salarioBruto - inss - impostoRenda;
		return salarioLiquido;
	}
}
