package com.foxminded.model;

public class AbbreviationData {
    private static final String FILE_SEPARATOR = "_";
    private final String racerAbbreviation;
    private final String racerName;
    private final String racerTeam;

    private AbbreviationData(String racerAbbreviation, String racerName, String racerTeam) {
        this.racerAbbreviation = racerAbbreviation;
        this.racerName = racerName;
        this.racerTeam = racerTeam;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerTeam() {
        return racerTeam;
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public static AbbreviationData create(String inputLine) {
        String[] lineData = inputLine.split(FILE_SEPARATOR);
        return new AbbreviationData(lineData[0], lineData[1], lineData[2]);
    }
}
