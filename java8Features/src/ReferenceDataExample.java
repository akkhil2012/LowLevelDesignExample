import java.util.function.Consumer;

public class ReferenceDataExample {

    public static void main(String[] args) {

        Consumer<String> con =
        ReferenceDataExample::printReferenceData;

        con.accept("Testing");
    }


    private static void printReferenceData(String s){
        System.out.println(" value is " + s);

    }
}



