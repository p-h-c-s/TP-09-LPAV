import java.util.Scanner;


public class ThreadMain {

	
	public void printVet(int []vet){
		for(int i: vet){
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		int tamVet;
		int numThreads;
		ArrayEncapsulated arr;
		
		
		//para testar
		tamVet = 8;
		numThreads = 4;
		int []intervalos = new int[tamVet];
		//int []vet = new int[tamVet];
		int []vet = {1,1,1,1,1,1,1,1};
		
		
		int tamInterv = tamVet/numThreads;
	
		//[0,1,2,3,4,5,6,7]
		//[0,1 ; 2,3; 4,5; 6,7]
		
		int cont = 0;
		for(int i = 0; i < tamVet; i+=(tamInterv-1)){
			intervalos[cont] = i;
			cont++;
			
		}
		
		Thread threads[] = new Thread[numThreads];
		
		int contThreads = 0;
		for(int i = 0; i < tamVet-1; i +=tamInterv){
			arr = new ArrayEncapsulated(intervalos[i],intervalos[i+1],vet);
			Worker wk = new Worker(arr);
			threads[contThreads] = new Thread(wk);
			threads[contThreads].start();
			contThreads++;
		}
		
		for(Thread t: threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		System.out.println("saida:");
		GlobalVar.printVar();
		//tamanho dos Intervalos == tamVet/numThreads
		
	}

}
