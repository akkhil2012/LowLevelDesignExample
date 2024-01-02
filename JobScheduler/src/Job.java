public abstract  class Job {


    String jobId;

    public Job(String jobId) {
        this.jobId = jobId;
    }

    abstract void executeJob(String job);
}
