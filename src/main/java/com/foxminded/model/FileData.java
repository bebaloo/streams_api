package com.foxminded.model;

public class FileData {
    protected String racerAbbreviation;
    
    protected FileData(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }
    
}
