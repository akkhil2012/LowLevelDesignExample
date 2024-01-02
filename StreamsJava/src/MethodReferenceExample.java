import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReferenceExample {

    public static void main(String args[]) {

        String input = "ilovejavatechie";

        Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().forEach(System.out::println);



       /* TestClass t =  null;

        Optional.of(t);

        Optional.ofNullable(t);
       // t.test();

        DemoInterface demo = TestClass::test;*/



       /* long start = 0,end = 0;
        start  = System.currentTimeMillis();
        IntStream.range(1,100).forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("1 :  " + (end-start));



        start  = System.currentTimeMillis();
        IntStream.range(1,100).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("2 :  " + (end-start));*/
    }


}


interface DemoInterface{
    void test();
}

class TestClass{

     static void test(){
        System.out.println("testing........");
    }
}
