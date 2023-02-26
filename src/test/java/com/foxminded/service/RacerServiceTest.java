package com.foxminded.service;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.EndData;
import com.foxminded.model.ResultLap;
import com.foxminded.model.StartData;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacerServiceTest {
    private final RacerService generator = new RacerService();
    private final List<AbbreviationData> abbreviations = new ArrayList<>();

    private final AbbreviationData abbreviationData = new AbbreviationData("DTF", "Dmytro Tkachuk", "Foxminded");
    private final LocalDateTime startTime = LocalDateTime.of(2023, Month.FEBRUARY, 24, 10, 26);
    private final LocalDateTime endTime = LocalDateTime.of(2023, Month.FEBRUARY, 24, 10, 28);

    private final List<StartData> startLogs = new ArrayList<>();
    private final StartData startData = new StartData("DTF", startTime);

    private final List<EndData> endLogs = new ArrayList<>();
    private final EndData endData = new EndData("DTF", endTime);

    private final List<ResultLap> expectedResultLaps = new ArrayList<>();
    private final ResultLap resultLap = new ResultLap("DTF", "Dmytro Tkachuk", "Foxminded", startTime, endTime);

    @Test
    void generateResult_shouldReturnsListOfResultLaps_whenGivenListsOfEndDataStartDataAbbreviationData() {
        abbreviations.add(abbreviationData);
        startLogs.add(startData);
        endLogs.add(endData);
        expectedResultLaps.add(resultLap);

        List<ResultLap> actualResultLaps = generator.generateResult(abbreviations, startLogs, endLogs);

        assertEquals(expectedResultLaps, actualResultLaps);
    }

    @Test
    void generateResult1_shouldReturnsListOfResultLaps_whenGivenListsOfEndDataStartDataAbbreviationData() {
        abbreviations.add(abbreviationData);
        startLogs.add(startData);
        endLogs.add(endData);
        expectedResultLaps.add(resultLap);

        List<ResultLap> actualResultLaps = generator.generateResult1(abbreviations, startLogs, endLogs);

        assertEquals(expectedResultLaps, actualResultLaps);
    }
}