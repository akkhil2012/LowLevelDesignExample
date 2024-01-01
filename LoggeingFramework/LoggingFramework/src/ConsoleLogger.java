public class ConsoleLogger extends  AbstractLogger{


    public ConsoleLogger(int level) {
        this.levels = level;
    }

    @Override
    public void display(int level, String message, LoggerSubject loggerSubject) {
        System.out.println("From console");
        loggerSubject.notiyObserver(level,message);
    }
}
