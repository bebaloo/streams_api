package com.foxminded.model;

import java.time.LocalDateTime;

public class EndData extends FormulasLogsData {
    private final LocalDateTime racerEndTime;

    public EndData(String racerAbbreviation, LocalDateTime endTime) {
        super(racerAbbreviation);
        this.racerEndTime = endTime;
    }

    public LocalDateTime getRacerEndTime() {
        return racerEndTime;
    }

    public static EndData create(String inputLine) {
        String abbreviation = inputLine.substring(START_SUBSTRING_INDEX, END_SUBSTRING_INDEX);
        StringBuilder dateTime = new StringBuilder(inputLine.substring(END_SUBSTRING_INDEX));

        dateTime.setCharAt(DATE_TIME_INSERT_INDEX, DATE_TIME_INSERT_CHARACTER);
        LocalDateTime endTime = LocalDateTime.parse(dateTime);

        return new EndData(abbreviation, endTime);
    }
}
