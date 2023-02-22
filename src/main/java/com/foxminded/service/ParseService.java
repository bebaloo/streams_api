package com.foxminded.service;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.EndData;
import com.foxminded.model.StartData;

import java.util.List;
import java.util.stream.Collectors;

public class ParseService {
    private static final String ABBREVIATIONS_FILE_PATH = "src/main/resources/abbreviations.txt";
    private static final String END_FILE_PATH = "src/main/resources/end.log";
    private static final String START_FILE_PATH = "src/main/resources/start.log";
    private final FileReader reader;

    public ParseService() {
        this.reader = new FileReader();
    }

    public List<AbbreviationData> parseAbbreviations() {
        List<String> inputLines = reader.readLines(ABBREVIATIONS_FILE_PATH);

        return inputLines.stream().map(AbbreviationData::create).collect(Collectors.toList());
    }

    public List<EndData> parseEnd() {
        List<String> inputLines = reader.readLines(END_FILE_PATH);

        return inputLines.stream().map(EndData::create).collect(Collectors.toList());
    }

    public List<StartData> parseStart() {
        List<String> inputLines = reader.readLines(START_FILE_PATH);

        return inputLines.stream().map(StartData::create).collect(Collectors.toList());
    }
}
