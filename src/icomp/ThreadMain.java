package icomp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ThreadMain {

	/**
	 * Gera um vetor de tamanho tam aleatório.
	 * @param tam Tamanho do vetor
	 * @return	Vetor com valores aleatorios
	 */
	public static int[] generateRandomArray(int tam){
		Random rng = new Random(123);
		int[] vet = new int[tam];

		for (int i = 0; i < vet.length; i++) {
			vet[i] = rng.nextInt(10);
		}

		return vet;
	}

	public static void generateIntervals(int[] intervalos, int tamIntervalo, int tamVet){
		intervalos[0] = 0;
		int cont = 1;
		for(int i = 0; i < tamVet; i++){
			if((i+1) % tamIntervalo == 0){
				intervalos[cont] = i;
				cont++;
			}
		}

	}
	
	public static void main(String[] args) {
		int tamVet;
		int numThreads;
		ArrayEncapsulated arr;
		Scanner inp = new Scanner(System.in);
		System.out.println("Insira o tamanho inicial do vetor: ");
		tamVet = inp.nextInt();
		System.out.println("Insira o número de threads: ");
		numThreads = inp.nextInt();
		int tamInterv = tamVet/numThreads;
		int[] vet = generateRandomArray(tamVet);
		//vetor que representa os intervalos dos vetores a serem somados por cada thread
		int[] intervalos = new int[numThreads+1];
		generateIntervals(intervalos,tamInterv,tamVet);

		ArrayList<Thread> threads = new ArrayList<>();

		int sum = 0;
		for (int i :vet) {
			sum += i;
		}
		System.out.println("soma esperada: " + sum);



		for(int i = 0; i < numThreads; i++){
			arr = new ArrayEncapsulated(intervalos[i],intervalos[i+1],vet);
			Worker wk = new Worker(arr);
			Thread thread = new Thread(wk);
			thread.start();
			threads.add(thread);
		}
		/*
		for(int i = 0; i < tamInterv-1; i++){
			arr = new ArrayEncapsulated(intervalos[i],intervalos[i+1],vet);
			Worker wk = new Worker(arr);
			Thread thread = new Thread(wk);
			thread.start();
			threads.add(thread);
		}*/
		//da join para a main esperar as threads terminarem de executar
		for(Thread t: threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("saida:");
		GlobalVar.printVar();
		//tamanho dos Intervalos == tamVet/numThreads
		inp.close();
	}
}
