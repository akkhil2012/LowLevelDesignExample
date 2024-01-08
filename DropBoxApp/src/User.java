import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String password;

    public List<File> getFiles() {
        return files;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    List<File> files;
    List<Folder> folders;


    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.files = new ArrayList<>();
        this.folders = new ArrayList<>();
    }


    public void createFolder(String name){
        Folder folder = new Folder(name);
        folders.add(folder);
    }


    public void uploadFile(String name,byte[] data){
         File file = new File(name,this.name,data);
    }


}
