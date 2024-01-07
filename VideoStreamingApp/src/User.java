import java.util.HashSet;
import java.util.Set;

public class User {
    private String id;
    private String name;
    private Set<Video> watchedVideos;
    private Set<Video> likedVideos;
    private Set<Video> dislikedVideos;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        watchedVideos = new HashSet<>();
        likedVideos = new HashSet<>();
        dislikedVideos = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void watchVideo(Video video) {
        watchedVideos.add(video);
    }

    public void likeVideo(Video video) {
        likedVideos.add(video);
    }

    public void dislikeVideo(Video video) {
        dislikedVideos.add(video);
    }

    public Set<Video> getWatchedVideos() {
        return watchedVideos;
    }

    public Set<Video> getLikedVideos() {
        return likedVideos;
    }

    public Set<Video> getDislikedVideos() {
        return dislikedVideos;
    }
}
