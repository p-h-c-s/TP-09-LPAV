package icomp.barreira;

public class Barrier {

    static int numWorkersArrived = 0;
    static int numWorkers;

    public Barrier(int numWorkers) {
        Barrier.numWorkers = numWorkers;
    }

    public synchronized void sync(Worker wk){

            Barrier.numWorkersArrived++;
            while (Barrier.numWorkersArrived != numWorkers) {
                try {
                    System.out.println(Thread.currentThread().getId() + " segunda execução");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getId() + " saindo");
            notifyAll();
    }

}
