package com.gridnine.testing.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Segment {
    private final LocalDateTime dateTimeDeparture;
    private final LocalDateTime dateTimeArrival;

    public Segment(LocalDateTime dateTimeDeparture, LocalDateTime dateTimeArrival) {
        this.dateTimeDeparture = dateTimeDeparture;
        this.dateTimeArrival = dateTimeArrival;
    }

    public LocalDateTime getDateTimeDeparture() {
        return dateTimeDeparture;
    }

    public LocalDateTime getDateTimeArrival() {
        return dateTimeArrival;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + dateTimeDeparture.format(fmt) + '|' + dateTimeArrival.format(fmt)
                + ']';
    }
}
