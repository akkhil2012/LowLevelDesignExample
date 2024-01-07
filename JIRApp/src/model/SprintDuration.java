package model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SprintDuration {

    LocalDateTime fromDate;

    LocalDateTime toDate;

    public SprintDuration(LocalDateTime fromDate, LocalDateTime toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
