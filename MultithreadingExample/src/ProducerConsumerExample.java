import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {

   // static BlockingQueue<Resource> BlockingQueue;

    public static void main(String rags[]){

        BlockingQueue<Resource> BlockingQueue = new ArrayBlockingQueue<>(5);

        new Thread(new Producer(BlockingQueue)).start();

        new Thread(new Consumer(BlockingQueue)).start();

    }

}


class Producer implements  Runnable{

    Resource resource;

    public Producer(BlockingQueue<Resource> BlockingQueue) {
        this.BlockingQueue = BlockingQueue;
    }

    BlockingQueue<Resource> BlockingQueue;



    @Override
    public void run() {
      //  while(true){
            while (BlockingQueue.size()<5) {
                Resource resource = new Resource();
                BlockingQueue.add(resource);
                System.out.println("Added resource " + resource);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
      //  }
    }
}

class Consumer implements  Runnable{

    BlockingQueue<Resource> BlockingQueue;

    public Consumer(BlockingQueue<Resource> BlockingQueue) {
        this.BlockingQueue = BlockingQueue;
    }

    Resource resource;

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(">>> "+ BlockingQueue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Resource{


}
