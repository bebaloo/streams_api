package com.foxminded.model;

public class FormulasLogsData {
    private final String racerAbbreviation;

    protected FormulasLogsData(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }
}
