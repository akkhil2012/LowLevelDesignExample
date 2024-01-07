import java.util.Optional;

public class OptionalSample {

    public static void main(String[] args) {

        String test = "test";

        Optional<String> res =
        Optional.of(test);
        System.out.println(" Optional.of sample " + res.get());

        test=null;
        /*res =
                Optional.of(test);*/
        res = Optional.ofNullable(test);
        String result =
        res.orElse("Dummy");
        System.out.println(" Optional.ofNullable sample with null: " + result);



    }



}
