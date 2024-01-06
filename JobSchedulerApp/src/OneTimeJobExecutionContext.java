public class OneTimeJobExecutionContext implements  ExecutionContext{
    @Override
    public void execute() {
        System.out.println(" One time Job executed............");
    }
}
