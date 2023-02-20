package com.foxminded.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.foxminded.model.*;
import com.foxminded.service.parser.AbbreviationDataParseService;
import com.foxminded.service.parser.EndDataParseService;
import com.foxminded.service.parser.StartDataParseService;

public class ResultGenerator {
    private final String FILE_PATH_ABBREVIATIONS = "src/main/resources/abbreviations.txt";
    private final AbbreviationDataParseService abbreviationDataParseService = new AbbreviationDataParseService(
            FILE_PATH_ABBREVIATIONS);

    private final String FILE_PATH_START = "src/main/resources/start.log";
    private final StartDataParseService startDataParseService = new StartDataParseService(FILE_PATH_START);

    private final String FILE_PATH_END = "src/main/resources/end.log";
    private final EndDataParseService endDataParseService = new EndDataParseService(FILE_PATH_END);

    public List<ResultLap> generate() {
        List<ResultLap> results = new ArrayList<>();

        try {
            List<StartData> startLogs = startDataParseService.parse();
            List<EndData> endLogs = endDataParseService.parse();
            List<AbbreviationData> abbreviations = abbreviationDataParseService.parse();

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        results.sort(Comparator.comparing(ResultLap::getTimeLap));

        return results;
    }
}
