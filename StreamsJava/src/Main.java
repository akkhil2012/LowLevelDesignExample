import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*TestFunctionInterface testFunctionInterface
                = () -> {
            return "Test Interface with value.......";
        };
        System.out.println("Result is " + testFunctionInterface.testRetunr());

        testFunctionInterface.defultMethod();*/



      /*  TestFunctionInterfaceImpl interfaceImpl1
                  = new TestFunctionInterfaceImpl();

        System.out.println("1: " + interfaceImpl1.testRetunr());
        interfaceImpl1.defultMethod();


        TestFunctionInterfaceImplOverride interfaceImpl2
                = new TestFunctionInterfaceImplOverride();
        System.out.println("2: " + interfaceImpl2.testRetunr());
        interfaceImpl2.defultMethod();*/


        /*Function<Integer,Integer> funct = a -> a*2;
        System.out.println(" Func ans is " +  funct.apply(99));


        BiFunction<Integer,Integer,String> biFunction = (a,b) -> String.valueOf(a*b);
        System.out.println(" BiFunct ans is " +  biFunction.apply(99,99));

        Function<Integer,Integer> funct1 = a -> a*3;
       // funct1.andThen(funct).andThen(funct).apply(33)
        System.out.println(" >> " + funct1.andThen(funct).andThen(funct).apply(33));*/


        // predicate

        //consumer

        Consumer<Integer> consumer = t -> System.out.println("Printing t " + t);
        consumer.accept(100);

        List<Integer> lst = List.of(11,22,33,22,11);
        lst.forEach(System.out::println);

        System.out.println("---1----");

        lst.stream().collect(Collectors.toSet())
                .stream()
                .forEach(System.out::println);

        System.out.println("----2---");


        Map<Integer,Long> res =
        lst.stream()
                .collect(Collectors.groupingBy(i -> i,Collectors.counting()));
        res.entrySet().stream().forEach(System.out::println);


        System.out.println("----3---");
        List<List<Integer>> lst1 = new ArrayList<>();
        lst1.add(lst);
        lst1.add(lst);

        lst1.stream()
                .map(val -> val.stream())
                .collect(Collectors.toSet())
                .forEach(val -> System.out.println(" "+ val));

        List<String> words = Arrays.asList("Hello", "World");
        System.out.println("----4---");
        List<String> ans =
        words.stream()
                .flatMap(word -> Arrays.stream(word.split(" ")))
                .collect(Collectors.toList());

        ans.stream().forEach(System.out::println);

        int[] arr = {1,2,3,3,4};


        System.out.println("Sum is >>>>>" + Arrays.stream(arr)
                .reduce(Integer::sum).getAsInt());
















    }
}


@FunctionalInterface
interface TestFunctionInterface {
    String testRetunr();

    default void defultMethod(){
        System.out.println("Defualt method");
    }

}



class TestFunctionInterfaceImpl implements TestFunctionInterface{


    @Override
    public String testRetunr() {
        return "Normal method impl";
    }

    @Override
    public void defultMethod() {
        TestFunctionInterface.super.defultMethod();
    }
}




class TestFunctionInterfaceImplOverride implements  TestFunctionInterface{

    @Override
    public String testRetunr() {
        return "Defualt method being override";
    }

    @Override
    public void defultMethod() {
        System.out.println("Defualt method.....override with own impl");
    }
}