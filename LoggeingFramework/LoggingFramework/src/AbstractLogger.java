public abstract class AbstractLogger {
    int levels;

    AbstractLogger nextLevelLogger;

    void setNextLevelLogger(AbstractLogger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(int level,String message,LoggerSubject loggerSubject){

        if(level==this.levels){
            display(level,message,loggerSubject);
        }

        if(nextLevelLogger!=null){
            nextLevelLogger.logMessage(level,message,loggerSubject);
        }

    }


    public  abstract void display(int level,String message,LoggerSubject loggerSubject);

}
