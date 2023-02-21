package com.foxminded.model;

import java.time.LocalDateTime;

public class StartData extends FormulasLogsData {
    private final LocalDateTime racerStartTime;

    public StartData(String racerAbbreviation, LocalDateTime racerStartTime) {
        super(racerAbbreviation);
        this.racerStartTime = racerStartTime;
    }

    public LocalDateTime getRacerStartTime() {
        return racerStartTime;
    }
}
