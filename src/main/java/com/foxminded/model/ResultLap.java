package com.foxminded.model;

import java.time.Duration;

public class ResultLap {
    private String racerName;
    private String racerTeam;
    private Duration timeLap;
    
    public ResultLap(String racerName, String racerTeam, Duration timeLap) {
        this.racerName = racerName;
        this.racerTeam = racerTeam;
        this.timeLap = timeLap;
    }

    @Override
    public String toString() {
        return racerName + " | " + racerTeam + " | " +  timeLap;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerTeam() {
        return racerTeam;
    }

    public Duration getTimeLap() {
        return timeLap;
    }
}
