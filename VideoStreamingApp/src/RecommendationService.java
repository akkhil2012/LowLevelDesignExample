import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RecommendationService {
    public List<Video> getRecommendations(User user) {
        Set<Video> likedVideos = user.getLikedVideos();
        Set<Video> dislikedVideos = user.getDislikedVideos();
        Set<String> likedVideoIds = likedVideos.stream().map(Video::getId).collect(Collectors.toSet());
        Set<String> dislikedVideoIds = dislikedVideos.stream().map(Video::getId).collect(Collectors.toSet());
        List<Video> allVideos = VideoDatabase.getAllVideos();
        return allVideos.stream()
                .filter(video -> !likedVideoIds.contains(video.getId()) && !dislikedVideoIds.contains(video.getId()))
                .sorted((v1, v2) -> Double.compare(v2.getAverageRating(), v1.getAverageRating()))
                .collect(Collectors.toList());
    }
}
