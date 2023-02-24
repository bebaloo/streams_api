package com.foxminded.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class ResultLap {
    private final String abbreviation;
    private String racerName;
    private String racerTeam;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public ResultLap(String abbreviation, LocalDateTime startTime, LocalDateTime endTime) {
        this.abbreviation = abbreviation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ResultLap(String abbreviation, String racerName, String racerTeam, LocalDateTime startTime, LocalDateTime endTime) {
        this.abbreviation = abbreviation;
        this.racerName = racerName;
        this.racerTeam = racerTeam;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerTeam() {
        return racerTeam;
    }


    public String getFormattedTimeLap() {
        Duration timeLap = getDuration();
        Long min = timeLap.toMinutes() % 60;
        Long sec = timeLap.toSeconds() % 60;
        Long millis = timeLap.toMillis() % 60;
        return String.format("%d:%d.%d", min, sec, millis);
    }
    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public void setRacerTeam(String racerTeam) {
        this.racerTeam = racerTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultLap resultLap = (ResultLap) o;
        return Objects.equals(abbreviation, resultLap.abbreviation) && Objects.equals(racerName, resultLap.racerName) && Objects.equals(racerTeam, resultLap.racerTeam) && Objects.equals(startTime, resultLap.startTime) && Objects.equals(endTime, resultLap.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, racerName, racerTeam, startTime, endTime);
    }
}
