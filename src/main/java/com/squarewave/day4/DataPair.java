package com.squarewave.day4;

public class DataPair {

    private final PassportDataType passportDataType;
    private final String value;

    public DataPair(PassportDataType passportDataType, String value) {
        this.passportDataType = passportDataType;
        this.value = value;
    }

    public PassportDataType getPassportDataType() {
        return passportDataType;
    }

    public String getValue() {
        return value;
    }
}
