public class App {

    public static void main(String atgs[]) throws InterruptedException {

        Broker broker = new Broker("/tmp/store");

        Consumer consumer = new Consumer("concumer1",broker);
        Consumer consumer1 = new Consumer("concumer2",broker);


        Publisher publisher = new Publisher(broker);
        publisher.push("Sample Broker Message.......","topic1");


     //   Thread.sleep(3000);

        broker.run();


        System.out.println(" Broker system completed.......");

    }
}
