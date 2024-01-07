import java.util.ArrayList;
import java.util.List;

public class FlightCOntroller {



    FlightService service;

    FlightRepository flightRepository;


    public FlightCOntroller() {
        this.service = new FlightService();
        this.flightRepository = service.flightRepository;
        service.addSearchCreteria(new SeachByFlightPathCommandExecutor(flightRepository));
        service.addSearchCreteria(new SeachBySourceCommandExecutor(flightRepository));
        service.addSearchCreteria(new SeachByTargetCommandExecutor(flightRepository));


        Location from = new Location("Solan");
        Location to = new Location("Salogra");

        Route route = new Route(from,to);

        FlightData flightData = new FlightData(route);
      //  Flight flight = new Flight("1",flightData);


        service.addFlight(new Flight("1",flightData));
        service.addFlight(new Flight("2",flightData));
        service.addFlight(new Flight("3",flightData));
        service.addFlight(new Flight("4",flightData));
    }
    public void trackFlight(Command command){

    }

    public List<Flight> searchBySource(String from){
        return service.searchBySource(from);
    }

    public List<Flight> searchByTarget(String to){
        return service.searchByDestination(to);
    }

    public List<Flight> searchByRoute(String from,String to){
        return service.searchByFlightRoute(from,to);
    }
}
