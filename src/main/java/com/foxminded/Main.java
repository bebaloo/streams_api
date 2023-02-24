package com.foxminded;

import com.foxminded.model.AbbreviationData;
import com.foxminded.model.EndData;
import com.foxminded.model.StartData;
import com.foxminded.service.Formatter;
import com.foxminded.service.ParseService;
import com.foxminded.service.ResultGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AbbreviationData> abbreviations = new ParseService().parseAbbreviations();
        List<StartData> startLogs = new ParseService().parseStart();
        List<EndData> endLogs = new ParseService().parseEnd();
        new Formatter().format(new ResultGenerator().generate(abbreviations, startLogs, endLogs));
        System.out.println("-------------------------");
        new Formatter().format(new ResultGenerator().generate1(abbreviations, startLogs, endLogs));

    }
}
