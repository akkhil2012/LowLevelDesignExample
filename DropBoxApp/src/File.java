public class File {

    String name;
    String owner;
    byte[] data;

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public byte[] getData() {
        return data;
    }

    public File(String name, String owner, byte[] data) {
        this.name = name;
        this.owner = owner;
        this.data = data;
    }
}
