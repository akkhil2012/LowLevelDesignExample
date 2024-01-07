import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightCOntroller flightCOntroller
                  = new FlightCOntroller();


        List<Flight> res  =
        flightCOntroller.searchBySource("bySource Solan");

        System.out.println("Flights " + res);


        res=flightCOntroller.searchByTarget("byDestination Salogra");

        System.out.println("Flights " + res);



    }
}