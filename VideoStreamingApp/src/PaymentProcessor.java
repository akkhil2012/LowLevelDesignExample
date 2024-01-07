import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PaymentProcessor {
    private static  Map<User, Set<Video>> paidVideosByUser;
    private static  Map<User, Boolean> subscriptionsByUser;

    public PaymentProcessor() {
        paidVideosByUser = new HashMap<>();
        subscriptionsByUser = new HashMap<>();
    }

    public void pay(User user, Video video) {
        Set<Video> paidVideos = paidVideosByUser.get(user);
        if (paidVideos == null) {
            paidVideos = new HashSet<>();
            paidVideosByUser.put(user, paidVideos);
        }
        paidVideos.add(video);
    }

    public static  boolean hasPaid(User user, Video video) {
        Set<Video> paidVideos = paidVideosByUser.get(user);
        if (paidVideos == null) {
            return false;
        }
        return paidVideos.contains(video);
    }

    public void subscribe(User user) {
        subscriptionsByUser.put(user, true);
    }

    public static  boolean hasSubscribed(User user) {
        Boolean subscribed = subscriptionsByUser.get(user);
        if (subscribed == null) {
            return false;
        }
        return subscribed;
    }

    public void cancelSubscription(User user) {
        subscriptionsByUser.put(user, false);
    }
}
