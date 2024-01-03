import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String rags[]) {

        ResourcePool resourcePool = new ResourcePool(2);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    resourcePool.access();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }


}


class ResourcePool {

    private final Semaphore semaphore;


    ResourcePool(int poolSize) {
        this.semaphore = new Semaphore(poolSize);
    }

    public void access() throws InterruptedException {
        semaphore.acquire();
        System.out.println("Thread acceesing resource is  " + Thread.currentThread().getName());
        Thread.sleep(3000);
        System.out.println("-----------------------------------------------------------------");
        semaphore.release();
    }


}
