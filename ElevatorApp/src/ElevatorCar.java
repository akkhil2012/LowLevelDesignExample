public class ElevatorCar {
    int floorId;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    int elevatorCarId;

    public int getElevatorCarId() {
        return elevatorCarId;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorCar(int floorId, int elevatorCarId, Dispatcher dispatcher) {
        this.floorId = floorId;
        this.elevatorCarId = elevatorCarId;
        this.elevatorButtonPanel = new ElevatorButtonPanel(dispatcher);
        this.direction = Direction.IDLE;
    }

    ButtonPanel elevatorButtonPanel;
    Direction direction;

    public void callElevator(int floor) {
        System.out.println("Elevator is being called..........from "+ floor);
        this.direction = Direction.UP;

    }
}
