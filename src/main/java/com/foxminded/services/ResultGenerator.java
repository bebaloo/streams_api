package com.foxminded.services;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.foxminded.models.*;
import com.foxminded.services.parsers.AbbreviationDataParseService;
import com.foxminded.services.parsers.EndDataParseService;
import com.foxminded.services.parsers.StartDataParseService;

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
            List<StartData> startLogs = (List<StartData>) startDataParseService.parse();
            List<EndData> endLogs = (List<EndData>) endDataParseService.parse();
            List<AbbreviationData> abbreviations = (List<AbbreviationData>) abbreviationDataParseService.parse();

            for (StartData startData : startLogs) {
                for (EndData endData : endLogs) {
                    for (AbbreviationData abbreviationData : abbreviations) {
                        if (startData.getRacerAbbreviation().equals(endData.getRacerAbbreviation()) && startData.getRacerAbbreviation().equals(abbreviationData.getRacerAbbreviation())) {
                            LocalDateTime startTime = startData.getRacerStartTime();
                            LocalDateTime endTime = endData.getRacerEndTime();
                            Duration duration = Duration.between(startTime, endTime);

                            String string = duration.toMinutes() % 60 + ":" + duration.toSeconds() % 60 + "."
                                    + duration.toMillis() % 60;

                            String racerName = abbreviationData.getRacerName();
                            String racerTeam = abbreviationData.getRacerTeam();
                            
                            results.sort(Comparator.comparing(ResultLap::getTimeLap));

                            results.add(new ResultLap(racerName, racerTeam, string));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return results;
    }

}
