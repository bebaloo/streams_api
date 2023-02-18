package com.foxminded.models;

public class ResultLap {
    private String racerName;
    private String racerTeam;
    private String timeLap;
    
    public ResultLap(String racerName, String racerTeam, String timeLap) {
        this.racerName = racerName;
        this.racerTeam = racerTeam;
        this.timeLap = timeLap;
    }

    @Override
    public String toString() {
        return racerName + " | " + racerTeam + " | " +  timeLap + "\n";
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerTeam() {
        return racerTeam;
    }

    public String getTimeLap() {
        return timeLap;
    }
}
