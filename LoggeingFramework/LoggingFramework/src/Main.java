public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LoggerSubject loggerSubject = addObserver();
        doChaining().logMessage(2,"Test",loggerSubject);
    }

    private static  AbstractLogger doChaining(){
        AbstractLogger debugLogger = new DebugLogger(1);
        AbstractLogger consoleLogger = new ConsoleLogger(2);
        //AbstractLogger consoleLogger = new ConsoleLogger(1);
        debugLogger.setNextLevelLogger(consoleLogger);
        return debugLogger;
    }

    private static LoggerSubject addObserver(){
        LoggerSubject loggerSubject = new LoggerSubject();
        FileObserver fileObserver = new FileObserver();
        loggerSubject.addObserver(1,fileObserver);
        loggerSubject.addObserver(2,fileObserver);

        ConsoleObserver consoleObserver = new ConsoleObserver();
        loggerSubject.addObserver(1,consoleObserver);

        return loggerSubject;
    }
}