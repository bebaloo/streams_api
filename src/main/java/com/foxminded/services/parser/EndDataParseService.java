package com.foxminded.services.parser;

import java.time.LocalDateTime;
import java.util.List;

import com.foxminded.model.EndData;
import com.foxminded.model.FormulasLogsData;

public class EndDataParseService extends ParseService {

    @Override
    protected void parseList(List<FormulasLogsData> list, String line) {
        String abbreviation = line.substring(START_SUBSTRING_INDEX, END_SUBSTRING_INDEX);
        StringBuilder dateTime = new StringBuilder(line.substring(END_SUBSTRING_INDEX));
        dateTime.setCharAt(DATE_TIME_INSERT_INDEX, DATE_TIME_INSERT_CHARACTER);
        LocalDateTime endTime = LocalDateTime.parse(dateTime);
        
        list.add(new EndData(abbreviation, endTime));
    }

    public EndDataParseService(String FILE_PATH) {
        super(FILE_PATH);
    }
}
