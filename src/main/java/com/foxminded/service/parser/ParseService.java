package com.foxminded.service.parser;

import com.foxminded.exception.IncorrectFilePathException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ParseService implements ParseServiceInterface {
    private final String filePath;

    public List parse() {
        List<String> inputLines = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputLines.add(line);
            }
        } catch (IOException e) {
            throw new IncorrectFilePathException("Incorrect filepath:" + filePath, e);
        }

        return parseInputLines(inputLines);
    }

    protected ParseService(String filePath) {
        this.filePath = filePath;
    }
}
