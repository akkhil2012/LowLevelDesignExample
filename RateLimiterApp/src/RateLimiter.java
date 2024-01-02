public interface RateLimiter {
    boolean canAccess(Integer clientId);
}
