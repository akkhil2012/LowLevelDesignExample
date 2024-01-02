public class Main {
    public static void main(String[] args) {


        RateLimiter rateLimiter = new SlidingWindowImpl();
        for(int i=1;i<20;i++){
             boolean res =  rateLimiter.canAccess(1);
            System.out.println("Is Allowed  " + res);
        }


    }
}





