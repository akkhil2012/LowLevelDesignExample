public class DeployImpl implements IDeployImage{

    public void deployImage(Image image){
        // make image fail
        if(image.getVersion()=="20.0") {
            System.out.println("Image Deployment Failed..........");
            throw new CorruptImageException();
        }

    }
}
