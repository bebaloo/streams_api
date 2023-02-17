package com.foxminded.services;

import java.util.List;

import com.foxminded.models.AbbreviationData;
import com.foxminded.models.FileData;

public class AbbreviationParseService extends ParseService{
    
    @Override
    protected void listAdd(List<FileData> list, String line) {
        String[] lineData = line.split("_");
        list.add(new AbbreviationData(lineData[0], lineData[1], lineData[2]));
    }
    
    public AbbreviationParseService(String FILE_PATH) {
        super(FILE_PATH);
    }
}
