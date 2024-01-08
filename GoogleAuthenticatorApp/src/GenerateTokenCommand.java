public class GenerateTokenCommand implements TokenCommand{
    private TokenFactory tokenFactory;
    private String secretKey;
    private long currentTimeMillis;

    public GenerateTokenCommand(TokenFactory tokenFactory, String secretKey, long currentTimeMillis) {
        this.tokenFactory = tokenFactory;
        this.secretKey = secretKey;
        this.currentTimeMillis = currentTimeMillis;
    }

    public void execute() {
        // Execute token generation
        String generatedToken = tokenFactory.generateToken(secretKey, currentTimeMillis);
        System.out.println("Generated Token: " + generatedToken);
        // Additional logic, if needed
    }
}
