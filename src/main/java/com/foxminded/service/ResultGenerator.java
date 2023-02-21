package com.foxminded.service;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.EndData;
import com.foxminded.model.ResultLap;
import com.foxminded.model.StartData;
import com.foxminded.service.parser.AbbreviationDataParseService;
import com.foxminded.service.parser.EndDataParseService;
import com.foxminded.service.parser.StartDataParseService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResultGenerator {
    private final String FILE_PATH_ABBREVIATIONS = "src/main/resources/abbreviations.txt";
    private final AbbreviationDataParseService abbreviationDataParseService = new AbbreviationDataParseService();

    private final String FILE_PATH_START = "src/main/resources/start.log";
    private final StartDataParseService startDataParseService = new StartDataParseService();

    private final String FILE_PATH_END = "src/main/resources/end.log";
    private final EndDataParseService endDataParseService = new EndDataParseService();

    public List<ResultLap> generate() {
        List<ResultLap> results = new ArrayList<>();

        List<StartData> startLogs = startDataParseService.parse(FILE_PATH_START);
        List<EndData> endLogs = endDataParseService.parse(FILE_PATH_END);
        List<AbbreviationData> abbreviations = abbreviationDataParseService.parse(FILE_PATH_ABBREVIATIONS);

        for (StartData startData : startLogs) {
            for (EndData endData : endLogs) {
                for (AbbreviationData abbreviationData : abbreviations) {
                    if (startData.getRacerAbbreviation().equals(endData.getRacerAbbreviation()) && startData.getRacerAbbreviation().equals(abbreviationData.getRacerAbbreviation())) {
                        LocalDateTime startTime = startData.getRacerStartTime();
                        LocalDateTime endTime = endData.getRacerEndTime();

                        Duration timeLap = Duration.between(startTime, endTime);
                        String racerName = abbreviationData.getRacerName();
                        String racerTeam = abbreviationData.getRacerTeam();

                        results.add(new ResultLap(racerName, racerTeam, timeLap));
                    }
                }
            }
        }

        results.sort(Comparator.comparing(ResultLap::getTimeLap));

        return results;
    }
}
