
public class ArrayEncapsulated {

	int interv0;
	int intervF;
	int []vet;
	int somaTotal;

	
	public ArrayEncapsulated(int interv0, int intervF, int[] vet) {
		super();
		this.interv0 = interv0;
		this.intervF = intervF;
		this.vet = vet;
	}
	
	public void somaVet(){
		for(int i = this.interv0; i <= this.intervF; i++){
			this.somaTotal += vet[i];
		}
		///*
		System.out.println("intervalos: " + this.interv0 + " " + this.intervF + " Thread atual: " + Thread.currentThread().getId() + " valor: " + this.somaTotal);
		System.out.println();
		System.out.println();
		//*/
		GlobalVar.increment(this.somaTotal);
		
	}
}
