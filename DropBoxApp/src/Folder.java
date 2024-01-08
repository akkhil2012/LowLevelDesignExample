import java.util.ArrayList;
import java.util.List;

public class Folder {
    String name;
    List<File> files;
    List<Folder> folders;


    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.folders = new ArrayList<>();
    }


    public void addFile(File file){
        files.add(file);
    }

    public void addFolder(Folder folder){
        folders.add(folder);
    }

    public void removeFile(File file) {
        files.remove(file);
    }

    public void removeFolder(Folder folder) {
        folders.remove(folder);
    }
}
