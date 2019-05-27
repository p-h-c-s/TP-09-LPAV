package icomp;

import java.util.Random;
import java.util.Scanner;


public class ThreadMain {

	/**
	 * Gera um vetor de tamanho tam aleatório.
	 * @param tam Tamanho do vetor
	 * @return	Vetor com valores aleatorios
	 */
	private static int[] generateRandomArray(int tam){
		Random rng = new Random(123);
		int[] vet = new int[tam];

		for (int i:vet) i = rng.nextInt();
		return vet;
	}

	public static void generateIntervals(int[] intervalos, int tamIntervalo){
		int cont = 0;
		for(int i = 0; i < intervalos.length; i+=(tamIntervalo-1)){
			intervalos[cont] = i;
			cont++;
		}
		//esse if preenche o ultimo elemento do vetor caso ele nao esteja _todo preenchido
		if(cont < intervalos.length){
			intervalos[cont] = cont*(tamIntervalo-1);
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
		int[] intervalos = new int[tamVet];
		generateIntervals(intervalos,tamInterv);


		Thread[] threads = new Thread[numThreads];
		int contThreads = 0;
		for(int i = 0; i < tamVet-1; i +=tamInterv){
			arr = new ArrayEncapsulated(intervalos[i],intervalos[i+1],vet);
			Worker wk = new Worker(arr);
			threads[contThreads] = new Thread(wk);
			threads[contThreads].start();
			contThreads++;
		}
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
