package icomp;

public class Worker implements Runnable {

	ArrayEncapsulated arr;
	
	public Worker(ArrayEncapsulated arr){
		this.arr = arr;
	}
	
	@Override
	public void run() {
		arr.somaVet();

	}

}
