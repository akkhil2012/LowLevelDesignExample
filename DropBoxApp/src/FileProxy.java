import java.util.ArrayList;
import java.util.List;

public class FileProxy {
    private File file;
    private List<User> sharedWithUsers;
    // Other attributes and methods

    public FileProxy(File file) {
        this.file = file;
        this.sharedWithUsers = new ArrayList<>();
    }

    public void shareFileWithUser(User user) {
        sharedWithUsers.add(user);
    }

    public void revokeFileAccessForUser(User user) {
        sharedWithUsers.remove(user);
    }

}
