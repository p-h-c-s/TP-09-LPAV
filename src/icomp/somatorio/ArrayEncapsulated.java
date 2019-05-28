package icomp.somatorio;

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
		if(this.interv0 == 0){
			this.somaTotal += vet[this.interv0];
		}
		for(int i = this.interv0+1; i <= this.intervF; i++){
			this.somaTotal += vet[i];
		}

		//System.out.println("intervalos: " + this.interv0 + " " + this.intervF + " Thread atual: " + Thread.currentThread().getId() + " valor: " + this.somaTotal);

		GlobalVar.increment(this.somaTotal);
		
	}
}
