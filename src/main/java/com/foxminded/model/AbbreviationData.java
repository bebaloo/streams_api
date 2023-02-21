package com.foxminded.model;

public class AbbreviationData extends FormulasLogsData {
    private final String racerName;
    private final String racerTeam;

    public AbbreviationData(String racerAbbreviation, String racerName, String racerTeam) {
        super(racerAbbreviation);
        this.racerName = racerName;
        this.racerTeam = racerTeam;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerTeam() {
        return racerTeam;
    }
}
