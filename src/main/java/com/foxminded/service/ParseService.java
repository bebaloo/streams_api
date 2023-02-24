package com.foxminded.service;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.EndData;
import com.foxminded.model.StartData;

import java.util.List;

public class ParseService {
    private static final String ABBREVIATIONS_FILE_PATH = "src/main/resources/abbreviations.txt";
    private static final String END_FILE_PATH = "src/main/resources/end.log";
    private static final String START_FILE_PATH = "src/main/resources/start.log";
    private final FileReader reader;

    public ParseService() {
        this.reader = new FileReader();
    }

    public List<AbbreviationData> parseAbbreviations() {
        return reader.readLines(ABBREVIATIONS_FILE_PATH).stream().map(AbbreviationData::create).toList();
    }

    public List<EndData> parseEnd() {
        return reader.readLines(END_FILE_PATH).stream().map(EndData::create).toList();
    }

    public List<StartData> parseStart() {
        return reader.readLines(START_FILE_PATH).stream().map(StartData::create).toList();
    }
}
