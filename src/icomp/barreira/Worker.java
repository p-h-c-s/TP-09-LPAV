package icomp.barreira;

public class Worker implements Runnable {

    public void attemptToPassBarrier(){
        Barrier.sync(this);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " primeira execução");
        attemptToPassBarrier();
        System.out.println(Thread.currentThread().getId() + " terceira execução");
    }
}
