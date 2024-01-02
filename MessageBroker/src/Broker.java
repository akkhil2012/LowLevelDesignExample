import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Broker implements  Runnable{

    String localStore;
    Map<String,Topic> topicsMap;

    Map<String,List<Message>> topicToMessages;
    Map<String, List<Consumer>> topicToConsumerMap;

    public Broker(String localStore) {
        this.localStore = localStore;
        this.topicsMap = new HashMap<>();
        this.topicToMessages = new HashMap<>();
        this.topicToConsumerMap = new HashMap<>();
    }



    public void writeTotopic(Topic topic, Message message) {
        String topicName = topic.getTopicName();
        List<Message> messages = topicToMessages.getOrDefault(topicName,new ArrayList<>());
        messages.add(message);
        topicToMessages.put(topicName,messages);
        System.out.println("Message writen to topic...."+ topicName);
    }


    public void addConsumer(String topicName,Consumer consumer){
         List<Consumer> consumers =
          topicToConsumerMap.getOrDefault(topicToConsumerMap.get(topicName),new ArrayList<>());
          consumers.add(consumer);
          System.out.println("Added the consumer to topic " + topicName);
    }

    @Override
    public void run() {
        int topicToIterate = topicToConsumerMap.size();
        while(topicToIterate-->0){
             for(Map.Entry<String,List<Consumer>> cons : topicToConsumerMap.entrySet()){
                    String topicToRead  = cons.getKey();
                    List<Consumer> consumers =
                    cons.getValue();
                    consumers
                            .stream()
                            .forEach(consumer -> consumer.dispatch(topicToMessages.get(topicToRead)));
             }

        }
    }
}
