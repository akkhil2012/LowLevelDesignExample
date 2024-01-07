import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoDatabase {
    private static Map<String, Video> videosById;

    public VideoDatabase() {
        videosById = new HashMap<>();
    }

    public void addVideo(Video video) {
        videosById.put(video.getId(), video);
    }

    public Video getVideo(String id) {
        return videosById.get(id);
    }

    public static  List<Video> getAllVideos() {
        return (List<Video>) videosById.values();
    }
}
