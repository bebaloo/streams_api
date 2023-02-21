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
}
