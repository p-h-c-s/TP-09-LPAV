package icomp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class ThreadMain {


	static HashMap<Integer,Integer> tradutor = new HashMap<>();

	/**
	 * Gera um vetor de tamanho tam aleatório.
	 * @param tam Tamanho do vetor
	 * @return	Vetor com valores aleatorios
	 */
	public static int[] generateRandomArray(int tam, int seed){
		Random rng = new Random(seed);
		int[] vet = new int[tam];

		for (int i = 0; i < vet.length; i++) {
			vet[i] = rng.nextInt(1000);
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

	static void generateWorkers(int[] intervalos,int[] vet, int numThreads, ArrayList<Thread> threads) {
		for (int i = 0; i < numThreads; i++) {
			ArrayEncapsulated arr = new ArrayEncapsulated(intervalos[i], intervalos[i + 1], vet);
			Worker wk = new Worker(arr);
			Thread thread = new Thread(wk);
			thread.start();
			threads.add(thread);
		}

		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	


	public static long computationTime(int numThreads, int tamVet, int seed){

		int tamInterv = tamVet/numThreads;
		int[] vet = generateRandomArray(tamVet, seed);
		int[] intervalos = new int[numThreads+1];

		generateIntervals(intervalos,tamInterv,tamVet);
		ArrayList<Thread> threads = new ArrayList<>();

		long start = System.currentTimeMillis();
		//funcao que realmente executa o trabalho
		generateWorkers(intervalos,vet,numThreads,threads);
		long finish = System.currentTimeMillis();

		return finish-start;
	}

	public static long[][] generateTimeMatrix(int seed){
		ArrayList<Integer> numThreads = generatePowersofTwo(1,64);
		ArrayList<Integer> tamanhoVetores = generatePowersofTwo(1024,65536);
		long[][] matr = new long[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j <7 ; j++) {
				matr[i][j] = computationTime(numThreads.get(i),tamanhoVetores.get(j),seed);
			}
		}
		return matr;
	}

	public static ArrayList<Integer> generatePowersofTwo(int start, int end){
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = start; i <= end; i*=2) {
			arr.add(i);
		}
		return arr;
	}

	public static void main(String[] args) {


		int seed = 12304;
		long matr[][] = generateTimeMatrix(seed);
		for (int i = 0; i < 7; i++) {
			System.out.println();
			for (int j = 0; j <7; j++) {
				System.out.print(matr[i][j] + "ms, ");
			}
		}

	}
}
