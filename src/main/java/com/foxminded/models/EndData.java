package com.foxminded.models;

import java.time.LocalDateTime;

public class EndData extends FileData {
    private LocalDateTime racerEndTime;
    
    public EndData(String racerAbbreviation, LocalDateTime endTime) {
        super(racerAbbreviation);
        this.racerEndTime = endTime;
    }
    
    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }
    
    public void setRacerAbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }
    
    public LocalDateTime getRacerEndTime() {
        return racerEndTime;
    }

    public void setRacerEndTime(LocalDateTime racerEndTime) {
        this.racerEndTime = racerEndTime;
    }

    @Override
    public String toString() {
        return "EndData [endTime=" + racerEndTime + ", racerAbbreviation=" + racerAbbreviation + "]\n";
    }
}
