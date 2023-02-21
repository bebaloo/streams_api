package com.foxminded.model;

import java.time.LocalDateTime;

public class StartData extends FormulasLogsData {
    private final LocalDateTime racerStartTime;

    private StartData(String racerAbbreviation, LocalDateTime racerStartTime) {
        super(racerAbbreviation);
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
