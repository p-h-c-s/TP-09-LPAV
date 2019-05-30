package icomp.ContaPoupanca;

import java.util.Random;

public class Pessoa implements Runnable {

    private ContaPoupanca contaPoupanca;
    private int numSaques;
    /**
     * O Random é para poder setar todas pessoas com o mesmo objeto random na main.
     */
    private Random rng;

    public Pessoa(ContaPoupanca contaPoupanca, int numSaques, Random rng) {
        this.contaPoupanca = contaPoupanca;
        this.numSaques = numSaques;
        this.rng = rng;
    }

    @Override
    public void run() {
        for (int i = 0; i < numSaques; i++) {
            if(rng.nextInt(1) % 2 == 0){
                System.out.println("Pessoa " + Thread.currentThread().getId() + " depositando 100");
                contaPoupanca.deposito(100);
            }else{
                System.out.println("Pessoa " + Thread.currentThread().getId() + " sacando 100");
                contaPoupanca.saque(100);
            }
        }
    }
}
