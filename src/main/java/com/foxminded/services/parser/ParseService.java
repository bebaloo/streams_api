package com.foxminded.services.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ParseService implements ParseServiceInterface {
    private String filePath;

    public List parse() throws IOException {
        List<String> inputLines = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputLines.add(line);
            }
            bufferedReader.close();
        }

        return parseList(inputLines);
    }

    protected abstract List parseList(List<String> line);

    protected ParseService(String filePath) {
        this.filePath = filePath;
    }
}
