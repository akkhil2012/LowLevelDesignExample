import java.util.List;

public abstract class ExecutorCommand {
     FlightRepository flightRepository;


    public ExecutorCommand(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public abstract boolean isValid(Command command);
    public abstract List<Flight> search(Command command);
}
