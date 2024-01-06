import java.util.ArrayList;
import java.util.List;

public class TaskScheduler {

    private final List<Runnable> threads;
    private final TaskStore<ScheduledTask> taskStore;

    public TaskScheduler(ExecutorConfig executorConfig, TaskStore<ScheduledTask> taskStore) {
        this.threads = new ArrayList<>();
        this.taskStore = taskStore;
        for (int i = 0; i < executorConfig.getNumThreads(); i++) {
            Thread thread = new Thread(new TaskRunner(taskStore));
            thread.start();
            threads.add(thread);
        }
    }

    public void stop() {
        threads.forEach(t -> ((TaskRunner) t).stop());
    }

}
