import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Calendar {

    MeetingRoom meetingRoom;

    Map<String, Meeting> meetingsInCalender;

    public Calendar() {
        // this.meetingRoom = meetingRoom;
        this.meetingsInCalender = new HashMap<>();
    }

    public boolean checkIfCanBookMeeting(Meeting meeting) {
        if (meetingsInCalender.size() == 0)
            return true;

        LocalDateTime start = meeting.getStartTime();
        LocalDateTime end = meeting.getEndTime();

        Set<Meeting> meetingSet =
                meetingsInCalender
                        .entrySet()
                        .stream()
                        .map(values -> values.getValue())
                        .collect(Collectors.toSet());

        Optional<Meeting> meetingClased =
                meetingSet.stream()
                        .filter(meet -> (meet.getEndTime().compareTo(meeting.getEndTime()) < 0
                                && (meet.getStartTime().compareTo(meeting.getEndTime())) < 0))
                        .findFirst();

        if (meetingClased.isEmpty()) {
            return true;
        }
        return false;

    }

    public void bookNewMeeting(Meeting meeting) {
        meetingsInCalender.put(meeting.getMeetingId(), meeting);
    }
}
