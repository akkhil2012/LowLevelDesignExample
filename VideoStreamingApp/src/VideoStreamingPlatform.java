import java.util.List;

public class VideoStreamingPlatform {
    private UserDatabase userDatabase;
    private VideoDatabase videoDatabase;
    private PaymentProcessor paymentProcessor;
    private RecommendationService recommendationService;
    private PlaybackService playbackService;
    private NotificationService notificationService;

    public VideoStreamingPlatform() {
        userDatabase = new UserDatabase();
        videoDatabase = new VideoDatabase();
        paymentProcessor = new PaymentProcessor();
        recommendationService = new RecommendationService();
        playbackService = new PlaybackService();
        notificationService = new NotificationService();
    }

    public void signUpUser(User user) {
        userDatabase.addUser(user);
    }

    public void uploadVideo(String userId, Video video) {
        User user = userDatabase.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id");
        }
        video.setUser(user);
        videoDatabase.addVideo(video);
        notificationService.notifyVideoUploaded(user, video);
    }

    public void watchVideo(String userId, String videoId) {
        User user = userDatabase.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id");
        }
        Video video = videoDatabase.getVideo(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Invalid video id");
        }
        boolean isFree = video.isFree();
        boolean isPaid = video.isPaid();
        boolean isSubscription = video.isSubscription();
        if (isFree) {
            playbackService.playVideo(user, video);
        } else if (isPaid) {
            boolean hasPaid = paymentProcessor.hasPaid(user, video);
            if (hasPaid) {
                playbackService.playVideo(user, video);
            } else {
                notificationService.notifyPaymentRequired(user);
            }
        } else if (isSubscription) {
            boolean hasSubscribed = paymentProcessor.hasSubscribed(user);
            if (hasSubscribed) {
                playbackService.playVideo(user, video);
            } else {
                notificationService.notifySubscriptionRequired(user);
            }
        }
    }

    public List<Video> getRecommendations(String userId) {
        User user = userDatabase.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id");
        }
        return recommendationService.getRecommendations(user);
    }

    public void rateVideo(String userId, String videoId, int rating) {
        User user = userDatabase.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id");
        }
        Video video = videoDatabase.getVideo(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Invalid video id");
        }
        video.addRating(rating);
    }

    public void payForVideo(String userId, String videoId) {
        User user = userDatabase.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id");
        }
        Video video = videoDatabase.getVideo(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Invalid video id");
        }
        if (!video.isPaid()) {
            throw new IllegalArgumentException("Video is not paid");
        }
        paymentProcessor.pay(user, video);
        notificationService.notifyPaymentSuccessful(user, video);
    }

    public void subscribe(String userId) {
        User user = userDatabase.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id");
        }
        paymentProcessor.subscribe(user);
        notificationService.notifySubscriptionSuccessful(user);
    }

    public void cancelSubscription(String userId) {
        User user = userDatabase.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user id");
        }
        paymentProcessor.cancelSubscription(user);
        notificationService.notifySubscriptionCancelled(user);
    }
}

