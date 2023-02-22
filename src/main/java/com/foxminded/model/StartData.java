package com.foxminded.model;

import java.time.LocalDateTime;

public class StartData {
    private static final int START_SUBSTRING_INDEX = 0;
    private static final int END_SUBSTRING_INDEX = 3;
    private static final int DATE_TIME_INSERT_INDEX = 10;
    private static final char DATE_TIME_INSERT_CHARACTER = 'T';
    private final LocalDateTime racerStartTime;
    private final String racerAbbreviation;

    private StartData(String racerAbbreviation, LocalDateTime racerStartTime) {
        this.racerAbbreviation = racerAbbreviation;
        this.racerStartTime = racerStartTime;
    }

    public LocalDateTime getRacerStartTime() {
        return racerStartTime;
    }

    public static StartData create(String inputLine) {
        String abbreviation = inputLine.substring(START_SUBSTRING_INDEX, END_SUBSTRING_INDEX);
        StringBuilder dateTime = new StringBuilder(inputLine.substring(END_SUBSTRING_INDEX));

        dateTime.setCharAt(DATE_TIME_INSERT_INDEX, DATE_TIME_INSERT_CHARACTER);
        LocalDateTime startTime = LocalDateTime.parse(dateTime);

        return new StartData(abbreviation, startTime);
    }
}
