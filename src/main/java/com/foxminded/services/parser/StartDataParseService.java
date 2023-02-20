package com.foxminded.services.parser;

import java.time.LocalDateTime;
import java.util.List;

import com.foxminded.model.FormulasLogsData;
import com.foxminded.model.StartData;

public class StartDataParseService extends ParseService {

    @Override
    protected void parseList(List<FormulasLogsData> list, String line) {
        String abbreviation = line.substring(START_SUBSTRING_INDEX, END_SUBSTRING_INDEX);
        StringBuilder dateTime = new StringBuilder(line.substring(END_SUBSTRING_INDEX));
        dateTime.setCharAt(DATE_TIME_INSERT_INDEX, DATE_TIME_INSERT_CHARACTER);
        LocalDateTime racerStartTime = LocalDateTime.parse(dateTime);
        
        list.add(new StartData(abbreviation, racerStartTime));
    }

    public StartDataParseService(String FILE_PATH) {
        super(FILE_PATH);
    }
}
