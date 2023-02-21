package com.foxminded.service.parser;

import com.foxminded.model.EndData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EndDataParseService extends ParseService {

    @Override
    public List parseInputLines(List<String> inputLines) {
        List<EndData> endDatas = new ArrayList<>();
        for (String line : inputLines) {
            String abbreviation = line.substring(START_SUBSTRING_INDEX, END_SUBSTRING_INDEX);
            StringBuilder dateTime = new StringBuilder(line.substring(END_SUBSTRING_INDEX));

            dateTime.setCharAt(DATE_TIME_INSERT_INDEX, DATE_TIME_INSERT_CHARACTER);
            LocalDateTime endTime = LocalDateTime.parse(dateTime);

            endDatas.add(new EndData(abbreviation, endTime));
        }
        return endDatas;
    }
}
