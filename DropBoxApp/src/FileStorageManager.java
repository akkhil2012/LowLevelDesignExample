import java.util.ArrayList;
import java.util.List;

public class FileStorageManager {

    private static FileStorageManager instance;

    public List<File> getFiles() {
        return files;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    private FileStorageManager() {
        this.files = new ArrayList<>();
        this.folders = new ArrayList<>();
    }

    public static FileStorageManager getInstance() {
        if (instance == null) {
            instance = new FileStorageManager();
        }
        return instance;
    }

    public void uploadFile(File file) {
        files.add(file);
    }

    public void deleteFile(File file) {
        files.remove(file);
    }

    public void createFolder(Folder folder) {
        folders.add(folder);
    }

    public void deleteFolder(Folder folder) {
        folders.remove(folder);
    }

    List<File> files;
    List<Folder> folders;
}
