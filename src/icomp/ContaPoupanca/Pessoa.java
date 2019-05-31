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
            //o bound do rng.nextInt() precisa ser 2 pq o bound é o valor máximo, sem ele mesmo.
            if(rng.nextInt(2) % 2 == 0){
                contaPoupanca.deposito(Thread.currentThread().getId(),100);
            }else{
                contaPoupanca.saque(Thread.currentThread().getId(),100);
            }
        }
    }
}
