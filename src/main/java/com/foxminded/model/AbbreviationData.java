package com.foxminded.model;

public class AbbreviationData extends FileData{
    private String racerName;
    private String racerTeam;
    
    public AbbreviationData(String racerAbbreviation, String racerName, String racerTeam) {
        super(racerAbbreviation);
        this.racerName = racerName;
        this.racerTeam = racerTeam;
    }
    
    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }
    public String getRacerName() {
        return racerName;
    }
    public String getRacerTeam() {
        return racerTeam;
    }
}
