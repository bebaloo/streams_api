package com.foxminded.models;

import java.time.LocalDateTime;

public class Start {
    private String racerAbraviation;
    private LocalDateTime racerStartTime;
    
    public String getRacerAbraviation() {
        return racerAbraviation;
    }
    public LocalDateTime getRacerStartTime() {
        return racerStartTime;
    }
    public void setRacerAbraviation(String racerAbraviation) {
        this.racerAbraviation = racerAbraviation;
    }
    public void setRacerStartTime(LocalDateTime racerStartTime) {
        this.racerStartTime = racerStartTime;
    }
}
