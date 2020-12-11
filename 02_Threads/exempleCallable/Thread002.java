package exempleCallable;

import java.util.concurrent.*;

/**
 * Exemple de multithreading amb objecte Callable i un Future.
 *
 * Es llença un objecte Callable des d'un ExecutorService amb un sol thread
 *  que realitza una suma de molts nombre en background.
 *  Mentres es realitza la suma, el thread principal mostra "." punts mentres
 *  s'esta executant la suma.
 *  Quan acaba el calcul obtenim el resultat a traves de l'objecte Future.get()
 *
 */
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

/**
 * Objecte callable que implementa el mètode call() que realitza
 * el calcul de la suma i retorna un valor.
 *
 * Abans d'executar s'ha d'haver inicialitzat el amb setNum()
 */
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
