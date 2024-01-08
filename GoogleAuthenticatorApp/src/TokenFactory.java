public interface TokenFactory {

    String generateToken(String secretKey, long currentTimeMillis);
}
