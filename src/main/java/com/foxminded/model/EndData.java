package com.foxminded.model;

import java.time.LocalDateTime;

public class EndData extends FormulasLogsData {
    private final LocalDateTime racerEndTime;

    public EndData(String racerAbbreviation, LocalDateTime endTime) {
        super(racerAbbreviation);
        this.racerEndTime = endTime;
    }

    @Override
    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public LocalDateTime getRacerEndTime() {
        return racerEndTime;
    }
}
