package com.foxminded.services.parsers;

import java.time.LocalDateTime;
import java.util.List;

import com.foxminded.models.EndData;
import com.foxminded.models.FileData;

public class EndDataParseService extends ParseService {

    @Override
    protected void listAdd(List<FileData> list, String line) {
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
