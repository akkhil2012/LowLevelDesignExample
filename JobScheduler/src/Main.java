import java.time.LocalDateTime;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

     ScheduledTask scheduledTask = new ScheduledTask();

     Job recurringJob = new RecurringScheduledJob("1",LocalDateTime.now().plusSeconds(3),3);
     scheduledTask.addJobToQueue(recurringJob);

     Deque<Job> jobs = scheduledTask.getJobs();

     AtomicInteger atomicInteger = new AtomicInteger(1);
     int count = 9;
     while(!jobs.isEmpty() && count!=0){
         Job nextJob = jobs.poll();
         nextJob.executeJob("Job ID" + atomicInteger);

         jobs.offer(new RecurringScheduledJob
                 (String.valueOf(atomicInteger.incrementAndGet()),
                         LocalDateTime.now().plusSeconds(2),3));
        count--;
     }



    }
}