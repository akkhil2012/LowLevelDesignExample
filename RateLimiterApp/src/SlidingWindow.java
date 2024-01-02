import javax.management.QueryEval;
import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindow {


    int CAPACITY = 10;
    int timeAllowedInSec = 1;
    Queue<Long> slidingQueue = new ArrayDeque<>(5);

    public boolean isAllowed() {
        long currentRequestTime = System.currentTimeMillis();
        int totalRequestsInQueue = fetchTheQueueSize(currentRequestTime);
        if(totalRequestsInQueue>=CAPACITY){
            return  false;
        }
        slidingQueue.add(currentRequestTime);
        return  true;
    }


    private int fetchTheQueueSize(Long currentRequestTime){
            if(slidingQueue.size()==0)
                return 0;

            long differenceSinceLastCall = currentRequestTime - slidingQueue.peek();
            while(differenceSinceLastCall>=timeAllowedInSec){
                   slidingQueue.poll();
                    if(slidingQueue.isEmpty())
                        break;
                differenceSinceLastCall = currentRequestTime - slidingQueue.peek();

            }
            return  slidingQueue.size();
    }
}
