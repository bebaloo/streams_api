package com.foxminded.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EndData {
    private static final int START_SUBSTRING_INDEX = 0;
    private static final int END_SUBSTRING_INDEX = 3;
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
        String abbreviation = inputLine.substring(START_SUBSTRING_INDEX, END_SUBSTRING_INDEX);

        String dateTime = inputLine.substring(END_SUBSTRING_INDEX);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        LocalDateTime endTime = LocalDateTime.parse(dateTime, formatter);

        return new EndData(abbreviation, endTime);
    }
}
