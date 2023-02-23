package com.foxminded.model;

import java.time.Duration;

public class ResultLap {
    private final String racerName;
    private final String racerTeam;
    private final Duration timeLap;

    public ResultLap(String racerName, String racerTeam, Duration timeLap) {
        this.racerName = racerName;
        this.racerTeam = racerTeam;
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
}
