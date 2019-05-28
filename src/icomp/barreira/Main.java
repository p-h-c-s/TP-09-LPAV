package icomp.barreira;

import icomp.somatorio.ArrayEncapsulated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Main {



	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int N = inp.nextInt();
		Barrier barrier = new Barrier(N);


		ArrayList<Thread> threads = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			Worker wk = new Worker(barrier);
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

	}
}
