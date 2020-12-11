package exempleCallable;

import java.util.concurrent.*;

public class Thread002 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadReturn task = new ThreadReturn();
        task.setNum(1_000_000_000L);
        System.out.println("waiting for result...");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> future = executorService.submit(task);

        System.out.print("calculating");
        while (true){
            System.out.print(".");
            Thread.sleep(500);
            if(future.isDone() || future.isCancelled()){
                System.out.println("");
                break;
            }
        }

        Long res = future.get().longValue();
        System.out.println("calculations done.");
        System.out.println("Resultat: " + res);
        executorService.shutdown();
    }
}

class ThreadReturn implements Callable<Long> {

    private long max_n;
    private long sum =0;

    public void setNum(long n){
        this.max_n = n;
    }
    @Override
    public Long call() throws Exception {
        for (int i = 0; i < this.max_n; i+=2) {
            sum += i;
        }
        return sum;
    }
}
