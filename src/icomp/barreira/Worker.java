package icomp.barreira;

public class Worker implements Runnable {

    Barrier barrier;

    public Worker(Barrier barrier) {
        this.barrier = barrier;
    }

    public void attemptToPassBarrier(){
        barrier.sync(this);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " primeira execução");
        attemptToPassBarrier();
        System.out.println(Thread.currentThread().getId() + " terceira execução");
    }
}
