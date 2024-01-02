import java.util.List;
import java.util.UUID;

public class MeetingRoom {

    String roomId;

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "roomId='" + roomId + '\'' +
                ", calendar=" + calendar +
                '}';
    }

    public String getRoomId() {
        return roomId;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    Calendar calendar;

    public MeetingRoom(String id) {
        this.roomId = id;
        this.calendar = new Calendar();
    }

    public void bookMeeting(Meeting meeting, Attendee bookedBy) {
        if (calendar.checkIfCanBookMeeting(meeting)) {
            calendar.bookNewMeeting(meeting);
        }

        sendInviteToAttendees(meeting.getAttendees(), meeting.getBookedBy());

    }

    void sendInviteToAttendees(List<Attendee> attendees, Attendee bookedBy) {
        EmailService service = new EmailService();
        service.sendInviteMail(attendees, bookedBy, "Templetd for meeting");

    }
}
