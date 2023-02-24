package com.foxminded.service;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.EndData;
import com.foxminded.model.ResultLap;
import com.foxminded.model.StartData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

public class ResultGenerator {
    private final ParseService parseService;

    public ResultGenerator() {
        parseService = new ParseService();
    }

    public List<ResultLap> generate() {
        Map<String, EndData> endLogs = parseService.parseEnd().stream()
                .collect(toMap(EndData::getRacerAbbreviation, identity()));

        Map<String, StartData> startLogs = parseService.parseStart().stream()
                .collect(toMap(StartData::getRacerAbbreviation, identity()));

        List<AbbreviationData> abbreviations = parseService.parseAbbreviations();

        return abbreviations.stream()
                .map(a -> new ResultLap(a.getRacerName(), a.getRacerTeam(),
                        Duration.between(startLogs.get(a.getRacerAbbreviation()).getRacerStartTime(),
                                endLogs.get(a.getRacerAbbreviation()).getRacerEndTime())))
                .sorted(comparing(ResultLap::getTimeLap)).toList();
    }

    public List<ResultLap> generate1() {
        List<EndData> endLogs = parseService.parseEnd();

        List<StartData> startLogs = parseService.parseStart();

        List<AbbreviationData> abbreviations = parseService.parseAbbreviations();
        
        List<ResultLap> resultLaps = new ArrayList<>();

        for (EndData endData : endLogs) {
            StartData startData = startLogs.stream()
                    .filter(sd -> sd.getRacerAbbreviation().equals(endData.getRacerAbbreviation())).findAny()
                    .orElse(null);
            
            resultLaps.add(new ResultLap(startData.getRacerAbbreviation(), Duration.between(startData.getRacerStartTime(), endData.getRacerEndTime())));
        }
        
        for (ResultLap resultLap : resultLaps) {
            AbbreviationData abbreviationData = abbreviations.stream()
                    .filter(sd -> sd.getRacerAbbreviation().equals(resultLap.getAbbreviation())).findAny()
                    .orElse(null);
            
            resultLap.setRacerName(abbreviationData.getRacerName());
            resultLap.setRacerTeam(abbreviationData.getRacerTeam());
        }

        return resultLaps;
    }
}