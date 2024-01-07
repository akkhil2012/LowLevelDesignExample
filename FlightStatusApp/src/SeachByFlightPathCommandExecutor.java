import java.util.List;

public class SeachByFlightPathCommandExecutor extends  ExecutorCommand{

    private final String SEARCH_BY_PATH = "byPath";

    public SeachByFlightPathCommandExecutor(FlightRepository flightRepository) {
        super(flightRepository);
    }


    @Override
    public boolean isValid(Command command) {
        return command.getSearchString().length()==2 &&
                command.getSearchString().contains(SEARCH_BY_PATH);
    }

    @Override
    public List<Flight> search(Command command) {
        String[] token = command.getSearchString().split(" ");
        return flightRepository.searchByPath(token);
    }
}
