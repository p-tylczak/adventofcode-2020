package com.squarewave.day4;

import java.util.Arrays;
import java.util.Optional;

public enum PassportDataType {

    BIRTH_YEAR("byr"),
    ISSUE_YEAR("iyr"),
    EXPIRATION_YEAR("eyr"),
    HEIGHT("hgt"),
    HAIR_COLOR("hcl"),
    EYE_COLOR("ecl"),
    PASSPORT_ID("pid"),
    COUNTRY_ID("cid");

    private final String alias;

    PassportDataType(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public static Optional<PassportDataType> fromAlias(String alias) {
        return Arrays.stream(PassportDataType.values())
                .filter(type -> type.getAlias().equals(alias))
                .findFirst();
    }
}
