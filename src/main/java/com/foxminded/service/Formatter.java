package com.foxminded.service;

import com.foxminded.model.ResultLap;

import java.util.List;

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
