package com.foxminded.model;

public class AbbreviationData extends FormulasLogsData {
    private final String racerName;
    private final String racerTeam;

    private AbbreviationData(String racerAbbreviation, String racerName, String racerTeam) {
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

    public static AbbreviationData create(String inputLine) {
        String[] lineData = inputLine.split(FILE_SEPARATOR);
        return new AbbreviationData(lineData[0], lineData[1], lineData[2]);
    }
}
