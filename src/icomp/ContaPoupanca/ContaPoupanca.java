package icomp.ContaPoupanca;

public class ContaPoupanca {

    private int saldo;


    public ContaPoupanca(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    private void printSalto(){
        System.out.println("Saldo atual: " + this.saldo);
    }

    public synchronized void saque(int saque) {
        this.saldo -= saque;
    }

    public synchronized void deposito(int deposito) {
        this.saldo += deposito;
    }
}
