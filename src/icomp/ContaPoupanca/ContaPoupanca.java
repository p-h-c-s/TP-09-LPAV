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

    public synchronized void saque(long threadId,int saque) {
        System.out.println("Pessoa " + threadId + " sacando 100");
        int newSaldo = this.saldo - saque;
        if(newSaldo < 0){
            System.out.println("Erro no saque da pessoa: " + threadId + " saldo negativo após operação.");
            return;
        }
        this.saldo -= saque;
        this.printSalto();
    }

    public synchronized void deposito(long threadId,int deposito) {
        System.out.println("Pessoa " + threadId + " depositando 100");
        this.saldo += deposito;
        this.printSalto();
    }
}
