package com.foxminded.service;

import com.foxminded.exception.IncorrectFilePathException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<String> readLines(String filePath) {
        List<String> inputLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputLines.add(line);
            }
        } catch (IOException e) {
            throw new IncorrectFilePathException("Incorrect filepath:" + filePath, e);
        }
        return inputLines;
    }
}
