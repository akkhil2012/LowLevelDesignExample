public class ElevatorRequest extends  Request{


    int floorId;

    public int getFloorId() {
        return floorId;
    }

    public ElevatorRequest(int floorId, Direction direction) {
        this.floorId = floorId;
        this.direction = direction;
    }

    Direction direction;



}
