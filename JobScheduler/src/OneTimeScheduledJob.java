import java.time.LocalDateTime;

public class OneTimeScheduledJob extends  Job{
    public OneTimeScheduledJob(String jobId, LocalDateTime firstJobTime) {
        super(jobId);
    }

    @Override
    void executeJob(String con) {
        System.out.println("<------One time Job-------->"+ con);
    }
}
