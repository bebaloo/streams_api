package com.foxminded.services.parser;

import java.time.LocalDateTime;
import java.util.List;

import com.foxminded.model.FormulasLogsData;
import com.foxminded.model.StartData;

public class StartDataParseService extends ParseService {

    @Override
    protected void parseList(List<FormulasLogsData> list, String line) {
        String abbreviation = line.substring(0, 3);
        StringBuilder dateTime = new StringBuilder(line.substring(3));
        dateTime.setCharAt(10, 'T');
        LocalDateTime racerStartTime = LocalDateTime.parse(dateTime);
        
        list.add(new StartData(abbreviation, racerStartTime));
    }

    public StartDataParseService(String FILE_PATH) {
        super(FILE_PATH);
    }
}
