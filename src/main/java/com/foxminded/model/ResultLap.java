package com.foxminded.model;

import java.time.Duration;

//TODO add StartTime and EndTime

public class ResultLap {
    private String abbreviation;
    private String racerName;
    private String racerTeam;
    private Duration timeLap;

    public ResultLap(String racerName, String racerTeam, Duration timeLap) {
        this.setRacerName(racerName);
        this.setRacerTeam(racerTeam);
        this.timeLap = timeLap;
    }
    
    public ResultLap(String abbreviation, Duration timeLap) {
        this.abbreviation = abbreviation;
        this.timeLap = timeLap;
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

    public String getFormattedTimeLap() {
        Long min = timeLap.toMinutes() % 60;
        Long sec = timeLap.toSeconds() % 60;
        Long millis = timeLap.toMillis() % 60;
        return String.format("%d:%d.%d", min, sec, millis);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public void setRacerTeam(String racerTeam) {
        this.racerTeam = racerTeam;
    }
}
