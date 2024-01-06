public class App {
    public static void  main(String atgs[]) throws InterruptedException {


        TaskStore<ScheduledTask> taskStore =
                new PriorityBlockingQueueTaskStore((task1,task2) -> Math.toIntExact(task1.getNextExecutionTime() - task2.getNextExecutionTime()),
                        4);

        OneTimeJobExecutionContext executionContext = new OneTimeJobExecutionContext();
        taskStore.add(new OneTimeTask(executionContext,System.currentTimeMillis()));

        TaskRunner t1 = new TaskRunner(taskStore);
        t1.run();

        Thread.sleep(3000);

        t1.stop();


    }
}
