package com.foxminded.service.parser;

import com.foxminded.exception.IncorrectFilePathException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ParseService implements ParseServiceInterface {
        public List parse(String filePath) {
        List<String> inputLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputLines.add(line);
            }
        } catch (IOException e) {
            throw new IncorrectFilePathException("Incorrect filepath:" + filePath, e);
        }

        return parseInputLines(inputLines);
    }
}
