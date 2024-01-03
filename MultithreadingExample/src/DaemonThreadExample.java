public class DaemonThreadExample {

    public static void main(String rags[]) throws InterruptedException {
        Runnable r = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Child thread running...");
            }
        };

        Thread childThread = new Thread(r);

        childThread.setDaemon(true);
        childThread.start();

        Thread.sleep(3000);

        System.out.println(" Main thread terminates...");

    }
}
