public class ConsoleObserver implements  Observer{
    @Override
    public void log(String message) {
        System.out.println(" From the COnsole SINK.......");
    }
}
