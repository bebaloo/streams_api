package com.foxminded.models;

import java.time.LocalDateTime;

public class EndData extends FileData {
    private LocalDateTime endTime;
    
    public EndData(String racerAbbreviation, LocalDateTime endTime) {
        super(racerAbbreviation);
        this.endTime = endTime;
    }
    
    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setRacerAbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
