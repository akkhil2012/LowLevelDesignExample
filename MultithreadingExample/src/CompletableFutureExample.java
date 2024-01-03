import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String rags[]) throws ExecutionException, InterruptedException {


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulating an asynchronous computation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        // Continue with another asynchronous operation using thenApply
        CompletableFuture<String> futureWithTransformation = future.thenApplyAsync(s -> s + " World");

        // Continue with another asynchronous operation using thenApply
        CompletableFuture<String> futureWithMoreTransformation = futureWithTransformation.thenApplyAsync(s -> s + "!");

        // Handling the result asynchronously
        futureWithMoreTransformation.whenCompleteAsync((result, throwable) -> {
            if (throwable == null) {
                System.out.println(result);
            } else {
                throwable.printStackTrace();
            }
        });

        // Wait for the asynchronous computations to complete
        try {
            Thread.sleep(3000); // Simulating additional work in the main thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        /*CallableTask completableTask
              = new CallableTask();

        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> result =
        service.submit(completableTask);

        while(!result.isDone()){
           // Thread.sleep(100);

            System.out.println(".....");

        }

        System.out.println("Result is " + result.get());
*/

        //service.shutdown();

    }


}

class RunnableTask implements Runnable{


    @Override
    public void run() {
        System.out.println(" Runnable task.................");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class CallableTask implements Callable{


    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return "CallableSample";

    }
}

