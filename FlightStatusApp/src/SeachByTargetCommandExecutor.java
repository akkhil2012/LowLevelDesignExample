import java.util.List;

public class SeachByTargetCommandExecutor extends  ExecutorCommand{

    private final String SEARCH_BY_TARGET = "byDestination";

    public SeachByTargetCommandExecutor(FlightRepository flightRepository) {
        super(flightRepository);
    }


    @Override
    public boolean isValid(Command command) {
        return command.getSearchString().length()>0 &&
                command.getSearchString().contains(SEARCH_BY_TARGET);
    }
    @Override
    public List<Flight> search(Command command) {
        String[] token = command.getSearchString().split(" ");
        return flightRepository.searchByTarget(token);
        //return flightRepository.searchByTarget(command.getSearchString());
    }
}
