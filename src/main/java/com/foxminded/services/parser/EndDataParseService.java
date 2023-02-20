package com.foxminded.services.parser;

import java.time.LocalDateTime;
import java.util.List;

import com.foxminded.model.EndData;
import com.foxminded.model.FormulasLogsData;

public class EndDataParseService extends ParseService {

    @Override
    protected void parseList(List<FormulasLogsData> list, String line) {
        String abbreviation = line.substring(0, 3);
        StringBuilder dateTime = new StringBuilder(line.substring(3));
        dateTime.setCharAt(10, 'T');
        LocalDateTime endTime = LocalDateTime.parse(dateTime);
        
        list.add(new EndData(abbreviation, endTime));
    }

    public EndDataParseService(String FILE_PATH) {
        super(FILE_PATH);
    }
}
