import java.util.HashMap;
import java.util.Map;

public class SlidingWindowImpl implements  RateLimiter{
    Map<Integer,SlidingWindow> userToLimitMapper;
    public SlidingWindowImpl() {
        this.userToLimitMapper = new HashMap<>();
    }

    @Override
    public boolean canAccess(Integer clientId) {
        //check if exists for User
        SlidingWindow slidingWindow = null;
        if(!userToLimitMapper.containsKey(clientId)){
            slidingWindow = new SlidingWindow();
            userToLimitMapper.put(clientId,slidingWindow);
        }else{
            slidingWindow  = userToLimitMapper.get(clientId);
        }
        boolean isAllowed = slidingWindow.isAllowed();
        return isAllowed;
    }
}
