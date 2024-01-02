public class Publisher {

    Topic topic;

    Message message;

    Broker broker;

    public Publisher(Broker broker) {
        this.broker = broker;
    }

    public void push(String msg, String topicName) {
        Topic topic = new Topic(topicName);
        Message message = new Message(msg);
        broker.writeTotopic(topic,message);

    }



}
