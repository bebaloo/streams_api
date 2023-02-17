package com.foxminded.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foxminded.models.FileData;

public abstract class ParseService {
    protected String FILE_PATH;
    
    public List<FileData> parse() throws FileNotFoundException {
        List<FileData> list = new ArrayList<>();
        
        File file = new File(FILE_PATH);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            listAdd(list, scanner.nextLine());
        }

        scanner.close();

        return list;
    }

    protected abstract void listAdd(List<FileData> list, String line);
           
    protected ParseService(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }
}
