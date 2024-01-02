import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class ScheduledTask {

    Deque<Job> jobs;

    public Deque<Job> getJobs() {
        return jobs;
    }

    public ScheduledTask() {
        this.jobs = new ArrayDeque<>();
    }


    public void addJobToQueue(Job job){
        jobs.push(job);
    }
}
