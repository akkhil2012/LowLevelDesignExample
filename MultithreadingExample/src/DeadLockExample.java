import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

    public static void main(String rags[]) throws InterruptedException {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();


        Runnable r1 = () -> {

            synchronized (lock1) {
                System.out.println("first thread : lock1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("first thread : lock2");
                }
            }


        };



        Runnable r2 = () -> {

            synchronized (lock2) {
                System.out.println("Second thread : lock2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Second thread : lock1");
                }
            }


        };

        new Thread(r1).start();

        new Thread(r2).start();


    }


}
