import java.util.ArrayList;
import java.util.List;

public class FlightService {

    FlightRepository flightRepository;

    List<ExecutorCommand> listOfExecutors;

    public FlightService() {
        this.flightRepository = new FlightRepository();
        listOfExecutors = new ArrayList<>();
    }

    public void addSearchCreteria(ExecutorCommand executorCommand){
        listOfExecutors.add(executorCommand);
    }


    public void addFlight(Flight flight){
        flightRepository.addFlight(flight);
    }


    public List<Flight> searchBySource(String from) {
        Command command = new Command(from);
        List<Flight> flights = null;
        for (ExecutorCommand commandExecutor : listOfExecutors) {
            if (commandExecutor.isValid(command)) {
                flights = commandExecutor.search(command);
            }
        }
        return flights;
    }


    public List<Flight> searchByFlightRoute(String routeFrom,String routeTo){
        Command command = new Command(routeFrom+ " "+ routeTo);
        List<Flight> flights = null;
        for (ExecutorCommand commandExecutor : listOfExecutors) {
            if (commandExecutor.isValid(command)) {
                flights = commandExecutor.search(command);
            }
        }
        return flights;
    }

    public List<Flight> searchByDestination(String to){
        Command command = new Command(to);
        List<Flight> flights = null;
        for (ExecutorCommand commandExecutor : listOfExecutors) {
            if (commandExecutor.isValid(command)) {
                flights = commandExecutor.search(command);
            }
        }
        return flights;
    }


}
