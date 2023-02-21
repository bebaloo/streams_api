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
                        + t.getFormattedTimeLap()));
    }
}
