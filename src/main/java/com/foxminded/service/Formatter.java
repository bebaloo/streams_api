package com.foxminded.service;

import java.time.Duration;
import java.util.List;

import com.foxminded.model.ResultLap;

public class Formatter {
    public void format(List<ResultLap> lapsResults) {
        lapsResults.forEach(t ->
                System.out.println(t.getRacerName()
                        + " | "
                        + t.getRacerTeam()
                        + " | "
                        + setTimeLap(t.getTimeLap())));
    }

    private String setTimeLap(Duration duration) {
        return duration.toMinutes() % 60 + ":" + duration.toSeconds() % 60 + "."
                + duration.toMillis() % 60;
    }
}
