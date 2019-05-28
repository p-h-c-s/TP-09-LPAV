package icomp.barreira;

public class Barrier {

    static int numWorkersArrived = 0;
    static int numWorkers;

    public Barrier(int numWorkers) {
        Barrier.numWorkers = numWorkers;
    }

    public static void sync(Worker wk){

        synchronized (wk) {
            Barrier.numWorkersArrived++;
            while (Barrier.numWorkersArrived != numWorkers) {
                System.out.println(Barrier.numWorkersArrived);
                try {
                    System.out.println(Thread.currentThread().getId() + " segunda execução");
                    wk.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getId() + " saindo");
            wk.notifyAll();
        }
    }

}
