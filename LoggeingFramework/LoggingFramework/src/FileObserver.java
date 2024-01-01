public class FileObserver implements  Observer{
    @Override
    public void log(String message) {
     System.out.println(" from theFile sync");
    }
}
