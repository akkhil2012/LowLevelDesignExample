import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeetingRepo {

    Map<String,MeetingRoom> meetingRooms;

    public MeetingRepo() {
        this.meetingRooms = new HashMap<>();

        meetingRooms.put("1",new MeetingRoom("1"));
        meetingRooms.put("2",new MeetingRoom("2"));
        meetingRooms.put("3",new MeetingRoom("3"));
    }


    public List<MeetingRoom> meetingRooms(){
        return meetingRooms.entrySet()
                .stream()
                .map(room -> room.getValue())
                .collect(Collectors.toList());
    }

}
