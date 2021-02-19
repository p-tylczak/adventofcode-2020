package com.squarewave.day4;

import java.util.List;

public class Passport {

    private final List<DataPair> passportData;

    public Passport(List<DataPair> passportData) {
        this.passportData = passportData;
    }

    public List<DataPair> getPassportData() {
        return passportData;
    }
}
