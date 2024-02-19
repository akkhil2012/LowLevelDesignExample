public class Image {

    private String imageName;

    private String version;

    private IPatch patch;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Image(String imageName) {
        this.imageName = imageName;
        version="2.0";
    }

    public String getImageName() {
        return imageName;
    }


    public void applyPatch(IPatch patch){
        this.patch = patch;
        System.out.println("Image patch applied successfully..........");
    }
}
