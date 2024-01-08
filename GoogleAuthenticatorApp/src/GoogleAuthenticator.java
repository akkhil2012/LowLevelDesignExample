public class GoogleAuthenticator {

    private static  GoogleAuthenticator instance;

    private TokenFactory tokenFactory;
    private TokenVerifier tokenVerifier;
    private UserDao userDao;
    private TokenOperationInvoker tokenOperationInvoker;



    public void generateAndExecuteTokenGenerationCommand(String userId,long currentTimeMillis){
        User user = userDao.getUser(userId);
        if (user != null) {
            String secretKey = user.getSecretKey();
            TokenCommand generateTokenCommand = new GenerateTokenCommand(tokenFactory, secretKey, currentTimeMillis);

            tokenOperationInvoker.setCommand(generateTokenCommand);
            tokenOperationInvoker.executeOperation();
        }
        }

    public void generateAndExecuteTokenVerificationCommand(String userId, String enteredCode, String generatedCode) {
        User user = userDao.getUser(userId);
        if (user != null) {
            // Create the token verification command
            TokenCommand verifyTokenCommand = new VerifyTokenCommand(tokenVerifier, enteredCode, generatedCode);
            // Set the command
            tokenOperationInvoker.setCommand(verifyTokenCommand);
            // Execute the command
            tokenOperationInvoker.executeOperation();
        }
    }



    private GoogleAuthenticator() {
        this.tokenFactory = new DefaultTokenFactory();
        this.tokenVerifier = new DefaultTokenVerifier();
        this.userDao = new InMemoryUserDao();
        this.tokenOperationInvoker = new TokenOperationInvoker();
    }

    public static GoogleAuthenticator getInstance() {
        if (instance == null) {
            instance = new GoogleAuthenticator();
        }
        return instance;
    }
}
