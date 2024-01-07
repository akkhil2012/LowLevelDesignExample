import java.util.*;
import java.util.stream.Collectors;

public class FlightRepository {
    Map<String, Flight> flights;

    public FlightRepository() {
        this.flights = new HashMap<>();
    }

    public void addFlight(Flight flight){
        String id = UUID.randomUUID().toString();
        flights.put(id,flight);
    }


    public List<Flight> searchBySource(String[] str) {
        List<Flight> res = new ArrayList<>();
        String searchString = str[1];

        for(Map.Entry<String,Flight> en : flights.entrySet()){
            String source = en.getValue().getFLightData().getRoute().getFrom().getLocationName();
            if(source.equals(searchString))
                res.add(en.getValue());

        }


        /*List<Flight> valuesList= flights.entrySet()
                .stream()
                .filter(fl -> fl.getValue().getFLightData().getRoute().getFrom().equals(searchString))
                .map(fl -> fl.getValue())
                .collect(Collectors.toList());*/

        return  res;

    }

    public List<Flight> searchByPath(String[] searchString) {
        String source = searchString[0];
        String target = searchString[1];

        List<Flight> valuesList= flights.entrySet()
                .stream()
                .filter(fl -> fl.getValue().getFLightData().getRoute().getTo().equals(target)
                  && fl.getValue().getFLightData().getRoute().getFrom().equals(source))
                .map(fl -> fl.getValue())
                .collect(Collectors.toList());

        return  valuesList;
    }

    public List<Flight> searchByTarget(String[] str) {
        String searchString = str[1];
        List<Flight> valuesList= flights.entrySet()
                .stream()
                .filter(fl -> fl.getValue().getFLightData().getRoute().getTo().equals(searchString))
                .map(fl -> fl.getValue())
                .collect(Collectors.toList());

        return  valuesList;
    }
}
