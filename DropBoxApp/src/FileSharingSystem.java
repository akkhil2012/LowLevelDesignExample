public class FileSharingSystem {

    public static void main(String[] args) {
        // Create users
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        // Upload files and create folders
        user1.uploadFile("file1.txt", new byte[]{});
        user1.createFolder("Folder 1");

        // Access file storage manager singleton
        FileStorageManager fileStorageManager = FileStorageManager.getInstance();
        fileStorageManager.uploadFile(user1.getFiles().get(0));

        // Create file proxy
        FileProxy fileProxy = new FileProxy(user1.getFiles().get(0));
        fileProxy.shareFileWithUser(user2);

        // Print uploaded files in the file storage manager
        for (File file : fileStorageManager.getFiles()) {
            System.out.println("File: " + file.getName());
        }
    }
}
