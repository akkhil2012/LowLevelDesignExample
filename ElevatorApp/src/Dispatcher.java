import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Dispatcher {
    Queue<Request> upDirectionRequests;
    Queue<Request> downDirectionRequests;

    ElevatorRepository elevatorRepository;


    public Dispatcher(ElevatorRepository elevatorRepository) {
        this.upDirectionRequests = new PriorityQueue<>();
        this.downDirectionRequests =
                new PriorityQueue<>((a,b) -> b.getFloorId()- a.getFloorId());
        this.elevatorRepository = elevatorRepository;
    }

    public void executeElevatorInnerRequest(Request request){
        ElevatorRequest elevatorRequest = (ElevatorRequest) request;

        if(elevatorRequest.direction==Direction.UP){
            sendUpRequestFromElevator(request);
        }else{
            sendDownRequestFromElevator(request.getFloorId());
        }
    }

    private void sendUpRequestFromElevator(Request request) {
        int fromFloor = request.getFromFloorId();
      // find idle elevator Cars
        List<ElevatorCar> carsWithIdleStatus =
        elevatorRepository.findtheIdleCarsAtfloor(fromFloor);

        if(carsWithIdleStatus.size()>0){
            ElevatorCar car = carsWithIdleStatus.get(0);
            car.callElevator(fromFloor);

            int id =
            elevatorRepository.getElevatorCarMap()
                    .entrySet()
                    .stream()
                    .map(cars -> cars.getKey())
                    .collect(Collectors.toList())
                    .stream()
                    .filter(c -> c==car.elevatorCarId)
                    .findAny()
                    .get();
            elevatorRepository.getElevatorCarMap().get(id).setDirection(Direction.UP);

        }else{
            upDirectionRequests.offer(request);
            System.out.println("Placed in Queue........");
        }


    }

    private void sendDownRequestFromElevator(int targetFloorId) {
    }


}
