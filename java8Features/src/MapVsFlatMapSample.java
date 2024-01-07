import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMapSample {

    public static void main(String[] args) {

        List<List<Person>> listOfLists = new ArrayList<>();

        // Adding sublists to the main list
        listOfLists.add(new ArrayList<>());  // Empty sublist
        listOfLists.add(new ArrayList<>(List.of(new Person("2",2),new Person("3",3))));  // Sublist with initial elements
        listOfLists.add(new ArrayList<>(List.of(new Person("4",4),new Person("5",5))));


        List<List<Person>> resultList =
        listOfLists.stream()
                .map(val -> val.stream())
                .map(val -> val.collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println(" general Map flattening");
        //resultList.stream().forEach(per -> System.out.println(" "+ per.get(0).getName()));
        resultList.stream().forEach(val -> val.stream().forEach(per -> System.out.println(" "+per.getName())));



        List<Person> resultListForFlatMap =
        listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("  Map flattening using flatMap");
        resultListForFlatMap.stream().forEach(per -> System.out.println(" "+ per.getName()));



        System.out.println("  ------- Sorted------- ");


        // sort the Collections
        List<Person> sortedList =
        resultListForFlatMap.stream().sorted((a,b) ->a.getName().compareTo(b.getName()))
                .collect(Collectors.toList());

        sortedList.stream().forEach(per -> System.out.println(" "+ per.getName()));


        // reduce Example
        int intResult =
        Stream.of(2,4,6,8)
                .reduce(0,(a,b) -> a+b);

        System.out.println(" Reduce result: " + intResult);


        Stream.of(2,4,6,8)
                .map(val -> val*val)
                .reduce(0,Integer::sum);

        System.out.println(" sum  " + Stream.of(2,4,6,8)
                .map(val -> val*val)
                .reduce(0,Integer::sum));

        System.out.println(" Max>  " + Stream.of(2,4,6,8)
                .map(val -> val*val)
                .reduce(0,Integer::max));


    }




}



class Person{

    String name;
    int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}



