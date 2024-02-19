//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // create image
        Image image = new Image("mbr-server");
        image.setVersion("20.0"); // to make image fail explicitly

        // deploy image
        IDeployImage deployImage = new DeployImpl();
        try {
            deployImage.deployImage(image);
        }catch(CorruptImageException e){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(".........Preparing Patch for Image..........");
            IPatch patch = new PatchImpl();
            patch.applyChangesInPatch("modified Value");
            image = new Image("mbr-server");
            image.setVersion("20.1");




            image.applyPatch(patch);
            deployImage.deployImage(image);

        }
        // check if any exception

             // if yes
             // create Patch
             // applyPatch

        // deploy image

        // retry count > accetable
              // delegate to admin

        // patch fixed issue

    }
}