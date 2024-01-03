import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String args[]){
        Set<ElevatorCar> cars = new HashSet<>();
        ElevatorRepository elevatorRepository
                = new ElevatorRepository();
        Dispatcher dispatcher = new Dispatcher(elevatorRepository);
        for(int i=0;i<5;i++){
            cars.add(new ElevatorCar(i,i,dispatcher));
        }

        elevatorRepository.addCars(cars);


        // request from inside the elevator
        Request innerRequest = new ElevatorRequest(1,Direction.UP);
        ElevatorButtonPanel elevatorButtonPanel = new ElevatorButtonPanel(dispatcher);
        elevatorButtonPanel.executeRequest(innerRequest);

        System.out.println("<------- Second request------->");

        innerRequest = new ElevatorRequest(1,Direction.UP);
        //elevatorButtonPanel = new ElevatorButtonPanel(dispatcher);
        elevatorButtonPanel.executeRequest(innerRequest);



    }
}
