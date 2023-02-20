package com.foxminded.services.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foxminded.model.FormulasLogsData;

public abstract class ParseService implements ParseServiceInterface {
    private String filePath;

    public List parse() throws FileNotFoundException {
        List<FormulasLogsData> fileDatas = new ArrayList<>();

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            parseList(fileDatas, scanner.nextLine());
        }

        scanner.close();

        return fileDatas;
    }

    protected abstract void parseList(List<FormulasLogsData> list, String line);

    protected ParseService(String filePath) {
        this.filePath = filePath;
    }
}
