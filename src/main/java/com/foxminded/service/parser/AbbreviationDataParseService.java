package com.foxminded.service.parser;

import java.util.ArrayList;
import java.util.List;

import com.foxminded.model.AbbreviationData;

public class AbbreviationDataParseService extends ParseService {
    @Override
    public List parseInputLines(List<String> inputLines) {
        List<AbbreviationData> abbreviationDatas = new ArrayList<>();

        for (String line : inputLines) {
            String[] lineData = line.split(LINE_DATA_SPLIT_CHARACTER);
            abbreviationDatas.add(new AbbreviationData(lineData[0], lineData[1], lineData[2]));
        }

        return abbreviationDatas;
    }
    
    public AbbreviationDataParseService(String filePath) {
        super(filePath);
    }
}
