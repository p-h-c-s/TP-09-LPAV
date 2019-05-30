package icomp.ContaPoupanca;

import icomp.barreira.Barrier;
import icomp.barreira.Worker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {


	//no intellij os parametros de linha de comando sao colocados em "edit configuration"
	public static void main(String[] args) {
		int N;
		int M;
		int saldoInicial = 5000;
		Random rng = new Random(123);
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		M = scanner.nextInt();

		//cria a conta compartilhada
		ContaPoupanca contaPoupanca = new ContaPoupanca(saldoInicial);

		ArrayList<Thread> threads = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			Pessoa wk = new Pessoa(contaPoupanca,M,rng);
			Thread thread = new Thread(wk);
			threads.add(thread);
			thread.start();
		}

		for (Thread t:threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Saldo final: " + contaPoupanca.getSaldo());

	}
}
