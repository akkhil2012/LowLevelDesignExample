import java.util.List;

public class SeachBySourceCommandExecutor extends  ExecutorCommand{


    private final String SEARCH_BY_SOURCE = "bySource";

    public SeachBySourceCommandExecutor(FlightRepository flightRepository) {
        super(flightRepository);
    }


    @Override
    public boolean isValid(Command command) {
        return command.getSearchString().length()>0 &&
                command.getSearchString().contains(SEARCH_BY_SOURCE);
    }

    @Override
    public List<Flight> search(Command command) {
        String[] token = command.getSearchString().split(" ");
        return flightRepository.searchBySource(token);
    }
}
