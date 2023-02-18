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

    public LocalDateTime getRacerEndTime() {
        return racerEndTime;
    }
}
