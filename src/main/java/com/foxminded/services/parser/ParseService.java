package com.foxminded.services.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foxminded.model.FormulasLogsData;

public abstract class ParseService implements ParseServiceInterface {
    private String filePath;

    public List parse() throws IOException {
        List<FormulasLogsData> fileDatas = new ArrayList<>();

        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parseList(fileDatas, line);
            }

            bufferedReader.close();
        }

        return fileDatas;
    }

    protected abstract void parseList(List<FormulasLogsData> list, String line);

    protected ParseService(String filePath) {
        this.filePath = filePath;
    }
}
