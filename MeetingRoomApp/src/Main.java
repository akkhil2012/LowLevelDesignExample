import java.time.LocalDateTime;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        //String meetingRoomId, String userId, LocalDateTime start, LocalDateTime end, List<Attendee> attendees
        SchedulerService service = new SchedulerService();
        List<Attendee> attendees = List.of(new Attendee("1"),new Attendee("2"));

        MeetingRoom room =
        service.bookMeeting("1","akkhil",LocalDateTime.now(),LocalDateTime.now().plusHours(2),attendees);

        System.out.println(" 1: Meeting boooked " + room.toString());

        service.bookMeeting("1","akkhil",LocalDateTime.now(),LocalDateTime.now().plusHours(1),attendees);

        System.out.println(" 2: Meeting boooked " + room.toString());

    }





}