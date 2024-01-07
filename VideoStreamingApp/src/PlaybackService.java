public class PlaybackService {
    public void playVideo(User user, Video video) {
        if (video.isPaid() && !PaymentProcessor.hasPaid(user, video)) {
            throw new IllegalArgumentException("User has not paid for video");
        }
        if (video.isSubscription() && !PaymentProcessor.hasSubscribed(user)) {
            throw new IllegalArgumentException("User is not subscribed");
        }
        user.watchVideo(video);
    }
}
