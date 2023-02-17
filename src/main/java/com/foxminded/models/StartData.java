package com.foxminded.models;

import java.time.LocalDateTime;

public class StartData extends FileData{
    private LocalDateTime racerStartTime;
    
    public StartData(String racerAbbreviation, LocalDateTime racerStartTime) {
        super(racerAbbreviation);
        this.racerStartTime = racerStartTime;
    }
    
    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }
    public LocalDateTime getRacerStartTime() {
        return racerStartTime;
    }
    public void setRacerAbraviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }
    public void setRacerStartTime(LocalDateTime racerStartTime) {
        this.racerStartTime = racerStartTime;
    }
}
