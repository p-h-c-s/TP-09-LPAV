package icomp;

public class GlobalVar {
	public static int var;
	
	//sincroniza no objeto da classe
	public static synchronized void increment(int incr){
		var += incr;
	}
	
	public static void printVar(){
		System.out.println(var);
	}

}
