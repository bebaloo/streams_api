package com.foxminded.model;

public class AbbreviationData {
    private static final String SEPARATOR = "_";
    private final String racerAbbreviation;
    private final String racerName;
    private final String racerTeam;

    public AbbreviationData(String racerAbbreviation, String racerName, String racerTeam) {
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
        String[] tokens = inputLine.split(SEPARATOR);
        return new AbbreviationData(tokens[0], tokens[1], tokens[2]);
    }
}
