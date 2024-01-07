import java.util.ArrayList;
import java.util.List;

public class Video {
    private String id;
    private String title;
    private User user;
    private List<Integer> ratings;
    private boolean isFree;
    private boolean isPaid;
    private boolean isSubscription;
    private double price;

    public Video(String id){
        this.id = id;
        ratings = new ArrayList<>();
    }

    public Video(String id, String title, User user, boolean isFree, boolean isPaid, boolean isSubscription, double price) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.isFree = isFree;
        this.isPaid = isPaid;
        this.isSubscription = isSubscription;
        this.price = price;
        ratings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    public void addRating(int rating) {
        ratings.add(rating);
    }

    public boolean isFree() {
        return isFree;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isSubscription() {
        return isSubscription;
    }

    public double getPrice() {
        return price;
    }
}
