package com.foxminded.service;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.EndData;
import com.foxminded.model.ResultLap;
import com.foxminded.model.StartData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class ResultGenerator {
    private final ParseService parseService;

    public ResultGenerator() {
        parseService = new ParseService();
    }

    public List<ResultLap> generate() {
        List<EndData> endLogs = parseService.parseEnd();
        List<StartData> startLogs = parseService.parseStart();
        List<AbbreviationData> abbreviations = parseService.parseAbbreviations();

        List<ResultLap> resultLaps = new ArrayList<>();

        for (StartData startData : startLogs) {
            for (EndData endData : endLogs) {
                for (AbbreviationData abbreviationData : abbreviations) {
                    if (startData.getRacerAbbreviation().equals(endData.getRacerAbbreviation()) && startData.getRacerAbbreviation().equals(abbreviationData.getRacerAbbreviation())) {
                        Duration duration = Duration.between(startData.getRacerStartTime(), endData.getRacerEndTime());
                        resultLaps.add(new ResultLap(abbreviationData.getRacerName(), abbreviationData.getRacerTeam(), duration));
                    }
                }
            }
        }
        return resultLaps.stream().sorted(comparing(ResultLap::getTimeLap)).toList();
    }
}