package com.foxminded.model;

public abstract class FormulasLogsData {
    protected static int START_SUBSTRING_INDEX = 0;
    protected static int END_SUBSTRING_INDEX = 3;

    protected static int DATE_TIME_INSERT_INDEX = 10;
    protected static char DATE_TIME_INSERT_CHARACTER = 'T';

    protected static String FILE_SEPARATOR = "_";
    private final String racerAbbreviation;

    protected FormulasLogsData(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }
}
