import java.time.LocalDateTime;

public class RecurringScheduledJob extends  Job{

    int interval;

    public int getInterval() {
        return interval;
    }

    public RecurringScheduledJob(String jobId, LocalDateTime firstJobTime, int span) {
        super(jobId);
        interval = span;
    }

    @Override
    void executeJob(String content) {
        System.out.println("<------One time Job-------->"+ content);
    }
}
