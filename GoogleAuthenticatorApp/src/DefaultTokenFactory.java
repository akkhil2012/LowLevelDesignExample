public class DefaultTokenFactory implements  TokenFactory{
    @Override
    public String generateToken(String secretKey, long currentTimeMillis) {
        return "dummyTokennull";
    }
}
