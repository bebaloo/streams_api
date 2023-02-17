package com.foxminded.models;

import java.time.LocalDateTime;

public class End {
    private String racerAbreviation;
    private LocalDateTime endTime;
    
    public String getRacerAbreviation() {
        return racerAbreviation;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setRacerAbreviation(String racerAbreviation) {
        this.racerAbreviation = racerAbreviation;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
