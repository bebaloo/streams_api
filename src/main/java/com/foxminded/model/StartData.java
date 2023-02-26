package com.foxminded.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartData {
    private static final int[] TOKEN_INDEXES = {0, 3};

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private final LocalDateTime racerStartTime;
    private final String racerAbbreviation;

    public StartData(String racerAbbreviation, LocalDateTime racerStartTime) {
        this.racerAbbreviation = racerAbbreviation;
        this.racerStartTime = racerStartTime;
    }

    public LocalDateTime getRacerStartTime() {
        return racerStartTime;
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public static StartData create(String inputLine) {
        String abbreviation = inputLine.substring(TOKEN_INDEXES[0], TOKEN_INDEXES[1]);

        String dateTime = inputLine.substring(TOKEN_INDEXES[1]);
        LocalDateTime startTime = LocalDateTime.parse(dateTime, TIME_FORMATTER);

        return new StartData(abbreviation, startTime);
    }
}
