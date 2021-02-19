package com.squarewave.day4;

import com.squarewave.common.utils.ParserUtils;

public class Day4 {

    private final PassportDataParser passportDataParser;
    private final ParserUtils parserUtils;

    public Day4(PassportDataParser passportDataParser, ParserUtils parserUtils) {
        this.passportDataParser = passportDataParser;
        this.parserUtils = parserUtils;
    }

    public long calculateNumberOfValidPassports(String fileName, PassportValidator passportValidator) {
        return passportDataParser.parse(parserUtils.readLines(fileName)).stream()
                .filter(passportValidator::isValid)
                .count();
    }

    public long calculateNumberOfValidPassports(String fileName, StrictPassportValidator passportValidator) {
        return passportDataParser.parse(parserUtils.readLines(fileName)).stream()
                .filter(passportValidator::isValid)
                .count();
    }
}
