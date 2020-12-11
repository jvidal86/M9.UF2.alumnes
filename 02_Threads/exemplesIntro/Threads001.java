package exemplesIntro;

public class Threads001  {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread());

        t1.setName("First Thread");

        t1.start();

        t1.join();

        System.out.println("End of Main thread");
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Beginning of Thread");
        for (int i = 0; i < 10; i++) {

        }
        System.out.println("End of thread " + Thread.currentThread().getName()
                + " with id = " + Thread.currentThread().getId());
    }
}
