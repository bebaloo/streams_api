package com.foxminded.service.parser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.foxminded.model.StartData;

public class StartDataParseService extends ParseService {

    @Override
    public List parseInputLines(List<String> inputLines) {
        List<StartData> startDatas = new ArrayList<>();
        for (String line : inputLines) {
            String abbreviation = line.substring(START_SUBSTRING_INDEX, END_SUBSTRING_INDEX);
            StringBuilder dateTime = new StringBuilder(line.substring(END_SUBSTRING_INDEX));

            dateTime.setCharAt(DATE_TIME_INSERT_INDEX, DATE_TIME_INSERT_CHARACTER);
            LocalDateTime racerStartTime = LocalDateTime.parse(dateTime);

            startDatas.add(new StartData(abbreviation, racerStartTime));
        }
        return startDatas;
    }

    public StartDataParseService(String filePath) {
        super(filePath);
    }
}
