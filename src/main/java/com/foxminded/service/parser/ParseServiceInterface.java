package com.foxminded.service.parser;

import java.io.IOException;
import java.util.List;

public interface ParseServiceInterface {
    int START_SUBSTRING_INDEX = 0;
    int END_SUBSTRING_INDEX = 3;

    int DATE_TIME_INSERT_INDEX = 10;
    char DATE_TIME_INSERT_CHARACTER = 'T';

    String LINE_DATA_SPLIT_CHARACTER = "_";

    List parse() throws IOException;
    List parseInputLines(List<String> inputLines);
}
