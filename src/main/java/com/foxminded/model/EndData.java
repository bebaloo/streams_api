package com.foxminded.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EndData {
    private static final int[] TOKEN_INDEXES = {0, 3};
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private final LocalDateTime racerEndTime;
    private final String racerAbbreviation;

    public EndData(String racerAbbreviation, LocalDateTime endTime) {
        this.racerAbbreviation = racerAbbreviation;
        this.racerEndTime = endTime;
    }

    public LocalDateTime getRacerEndTime() {
        return racerEndTime;
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public static EndData create(String inputLine) {
        String abbreviation = inputLine.substring(TOKEN_INDEXES[0], TOKEN_INDEXES[1]);

        String dateTime = inputLine.substring(TOKEN_INDEXES[1]);
        LocalDateTime endTime = LocalDateTime.parse(dateTime, TIME_FORMATTER);

        return new EndData(abbreviation, endTime);
    }
}
