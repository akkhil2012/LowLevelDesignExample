import java.util.List;

public class Consumer {

    String consumerName;

    Broker broker;

    public Consumer(String consumerName,Broker broker) {
        this.consumerName = consumerName;
        this.broker = broker;
        addConsumerToTopic(broker);
    }

    Topic topic;


    public void addConsumerToTopic(Broker broker){
        broker.addConsumer("Topic1", this);
    }

    public void dispatch(List<Message> messages) {
        messages.stream().forEach(System.out::println);
        System.out.println("Message reading done.............by " + this.consumerName);
    }
}


