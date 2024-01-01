import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerSubject {
    Map<Integer, List<Observer>> logeMapper;
    public LoggerSubject() {
        this.logeMapper = new HashMap<>();
    }

    public void addObserver(int level,Observer observer){
        List<Observer> lst = logeMapper.getOrDefault(level,new ArrayList<>());
        lst.add(observer);
        logeMapper.put(level,lst);
    }

    public void notiyObserver(int level,String message) {
        for(Map.Entry<Integer,List<Observer>> ocs : logeMapper.entrySet()){
             if(ocs.getKey()==level){
                  ocs.getValue().stream().forEach(consumer -> consumer.log(message));
             }
        }
    }
}
