package com.foxminded;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;

import com.foxminded.services.Formatter;
import com.foxminded.services.ResultGenerator;
import com.foxminded.services.parsers.AbbreviationDataParseService;
import com.foxminded.services.parsers.EndDataParseService;
import com.foxminded.services.parsers.StartDataParseService;


public class Main {
    public static void main(String[] args) {
              
        new Formatter().format(new ResultGenerator().generate());
    }
    
}
