package com.foxminded.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartData {
    private static final int[] TOKEN_INDEXES = {0, 3};
    private final LocalDateTime racerStartTime;
    private final String racerAbbreviation;

    private StartData(String racerAbbreviation, LocalDateTime racerStartTime) {
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        LocalDateTime startTime = LocalDateTime.parse(dateTime, formatter);

        return new StartData(abbreviation, startTime);
    }
}
