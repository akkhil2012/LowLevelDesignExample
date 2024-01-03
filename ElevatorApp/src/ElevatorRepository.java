import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ElevatorRepository {

    Set<ElevatorCar>elevators;

    Map<Integer,ElevatorCar> elevatorCarMap;

    public Map<Integer, ElevatorCar> getElevatorCarMap() {
        return elevatorCarMap;
    }

    public ElevatorRepository() {
        //this.elevators = elevators;
        this.elevatorCarMap = new HashMap<>();



    }

    public List<ElevatorCar> findtheIdleCarsAtfloor(int fromFloor) {
        return
        elevatorCarMap
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toSet())
                .stream()
                .filter(car -> car.getDirection().equals(Direction.IDLE))
                .collect(Collectors.toList());


    }

    public void addCars(Set<ElevatorCar> cars) {
        this.elevators = cars;
        for(ElevatorCar car : elevators){
            elevatorCarMap.put(car.getElevatorCarId(),car);
        }
    }
}
