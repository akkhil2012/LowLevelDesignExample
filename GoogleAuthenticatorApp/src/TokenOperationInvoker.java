public class TokenOperationInvoker {
    private TokenCommand tokenCommand;

    public void setCommand(TokenCommand tokenCommand) {
        this.tokenCommand = tokenCommand;
    }

    public void executeOperation() {
        // Execute the assigned command
        tokenCommand.execute();
    }

}
