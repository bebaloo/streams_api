package com.foxminded.services.parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foxminded.models.FileData;

public abstract class ParseService {
    protected String FILE_PATH;
    
    public List<?> parse() throws FileNotFoundException {
        List<FileData> list = new ArrayList<>();
        
        File file = new File(FILE_PATH);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            parseList(list, scanner.nextLine());
        }

        scanner.close();

        return list;
    }

    protected abstract void parseList(List<FileData> list, String line);
           
    protected ParseService(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }
}
