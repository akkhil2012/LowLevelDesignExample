import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    String meetingId;
    MeetingRoom meetingRoom;

    public String getMeetingId() {
        return meetingId;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public Attendee getBookedBy() {
        return bookedBy;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    List<Attendee> attendees;
    LocalDateTime startTime,endTime;

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    Attendee bookedBy;

    public Meeting(LocalDateTime startTime, LocalDateTime endTime, Attendee bookedBy) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookedBy = bookedBy;
    }
}
