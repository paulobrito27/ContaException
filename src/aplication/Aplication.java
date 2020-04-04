package aplication;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exception.ContaException;

public class Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			Conta conta = abreConta();
			System.out.println(conta);
			System.out.println("");
			System.out.println("-------------------------------------------------------");
			System.out.print("Informe valor para saque: ");
			double saque = sc.nextDouble();
			conta.saque(saque);
			System.out.println("-------------------------------------------------------");
			System.out.println(conta);
		} catch (ContaException e) {
			System.out.println("erro-> " + e);
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("erro-> " + e);
			System.out.println(e.getMessage());
		} finally {
			sc.close();
			System.out.println("fim....");
		}

	}

	public static Conta abreConta() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o nome do correntista: ");
		String correntista = sc.nextLine();
		System.out.print("Número da conta: ");
		Integer numero = sc.nextInt();
		System.out.print("Saldo inicial: ");
		Double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		Double limiteSaque = sc.nextDouble();
		sc.nextLine();
		Conta c = new Conta(numero, correntista, saldo, limiteSaque);
		return c;
	}

}
