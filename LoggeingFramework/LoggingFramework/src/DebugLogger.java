public class DebugLogger extends  AbstractLogger{
    public DebugLogger(int level) {
        this.levels = level;
    }

    @Override
    public void display(int level, String message, LoggerSubject loggerSubject) {
        System.out.println("from debug");
        loggerSubject.notiyObserver(level,message);
    }
}
