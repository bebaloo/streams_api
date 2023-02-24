package com.foxminded.service;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.EndData;
import com.foxminded.model.ResultLap;
import com.foxminded.model.StartData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

public class ResultGenerator {
    public List<ResultLap> generate(List<AbbreviationData> abbreviations, List<StartData> startLogs, List<EndData> endLogs) {
        Map<String, EndData> endLogsMap = endLogs.stream()
                .collect(toMap(EndData::getRacerAbbreviation, identity()));

        Map<String, StartData> startLogsMap = startLogs.stream()
                .collect(toMap(StartData::getRacerAbbreviation, identity()));

        return abbreviations.stream()
                .map(a -> new ResultLap(a.getRacerAbbreviation(),
                        a.getRacerName(),
                        a.getRacerTeam(),
                        startLogsMap.get(a.getRacerAbbreviation()).getRacerStartTime(),
                        endLogsMap.get(a.getRacerAbbreviation()).getRacerEndTime()))
                .sorted(comparing(ResultLap::getDuration)).toList();
    }

    public List<ResultLap> generate1(List<AbbreviationData> abbreviations, List<StartData> startLogs, List<EndData> endLogs) {
        List<ResultLap> resultLaps = new ArrayList<>();

        for (EndData endData : endLogs) {
            StartData startData = startLogs.stream()
                    .filter(sd -> sd.getRacerAbbreviation().equals(endData.getRacerAbbreviation())).findAny()
                    .orElse(null);

            resultLaps.add(new ResultLap(startData.getRacerAbbreviation(), startData.getRacerStartTime(), endData.getRacerEndTime()));
        }
        
        for (ResultLap resultLap : resultLaps) {
            AbbreviationData abbreviationData = abbreviations.stream()
                    .filter(sd -> sd.getRacerAbbreviation().equals(resultLap.getAbbreviation())).findAny()
                    .orElse(null);
            
            resultLap.setRacerName(abbreviationData.getRacerName());
            resultLap.setRacerTeam(abbreviationData.getRacerTeam());
        }

        return resultLaps.stream().sorted(comparing(ResultLap::getDuration)).toList();
    }
}