import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WaitSignalAll {
    public static void main(String[] args) {
        final  Object msg = new Object();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ThreadWaitSignalAll t1 = new ThreadWaitSignalAll(msg);
        ThreadWaitSignalAll t2 = new ThreadWaitSignalAll(msg);
        ThreadWaitSignalAll t3 = new ThreadWaitSignalAll(msg);
        new CheckCancel(pool).start();

        pool.submit(t1);
        pool.submit(t2);
        pool.submit(t3);
    }
}

class ThreadWaitSignalAll extends Thread {
    static int finished = 0; // variable compartida
    int round = 0;
    Object msg;
    public ThreadWaitSignalAll(Object msg) {
        this.msg = msg;
    }
    @Override
    public void run() {
        while(true) {
            //calcula algo...
            System.out.printf("[%d] round: %d\n", Thread.currentThread().getId(), round);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //espera que tots acabin...
            synchronized (msg) {
                if (finished < 2) {
                    finished++;
                    System.out.printf("[%d] gonna wait, finished: %d\n", Thread.currentThread().getId(), finished);
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.printf("[%d] gonna notify\n", Thread.currentThread().getId());
                    finished = 0;
                    msg.notifyAll();
                }
            }
            //passa de ronda
            round++;
        }
    }
}
