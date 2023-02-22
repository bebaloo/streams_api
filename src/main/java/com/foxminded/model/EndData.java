package com.foxminded.model;

import java.time.LocalDateTime;

public class EndData {
    private static final int START_SUBSTRING_INDEX = 0;
    private static final int END_SUBSTRING_INDEX = 3;
    private static final int DATE_TIME_INSERT_INDEX = 10;
    private static final char DATE_TIME_INSERT_CHARACTER = 'T';
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
        StringBuilder dateTime = new StringBuilder(inputLine.substring(END_SUBSTRING_INDEX));

        dateTime.setCharAt(DATE_TIME_INSERT_INDEX, DATE_TIME_INSERT_CHARACTER);
        LocalDateTime endTime = LocalDateTime.parse(dateTime);

        return new EndData(abbreviation, endTime);
    }
}
