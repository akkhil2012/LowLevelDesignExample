import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class SchedulerService {

    MeetingRepo meetingRepo;

    public SchedulerService() {
        this.meetingRepo = new MeetingRepo();
    }

    public MeetingRoom bookMeeting(String meetingRoomId, String userId, LocalDateTime start, LocalDateTime end, List<Attendee> attendees){
        MeetingRoom roomToBook = null;

        Optional<MeetingRoom> roomAvailable =
             meetingRepo.meetingRooms()
                     .stream()
                     .filter(room -> room.getRoomId().equals(meetingRoomId))
                     .findFirst();

        if(roomAvailable.isPresent()){
            roomToBook = roomAvailable.get();
        }else{
            throw  new RoomNotFoundException("Room mot found");
        }

        Attendee bookedBy = new Attendee(userId);
        Meeting meeting = new Meeting(start,end,bookedBy);
        roomToBook.bookMeeting(meeting,bookedBy);
        System.out.println(" Meeting booked ");

        return  roomToBook;


    }
}
