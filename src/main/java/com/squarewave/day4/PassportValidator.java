package com.squarewave.day4;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.squarewave.day4.PassportDataType.BIRTH_YEAR;
import static com.squarewave.day4.PassportDataType.EXPIRATION_YEAR;
import static com.squarewave.day4.PassportDataType.EYE_COLOR;
import static com.squarewave.day4.PassportDataType.HAIR_COLOR;
import static com.squarewave.day4.PassportDataType.HEIGHT;
import static com.squarewave.day4.PassportDataType.ISSUE_YEAR;
import static com.squarewave.day4.PassportDataType.PASSPORT_ID;

public class PassportValidator {

    private final List<PassportDataType> requiredDataTypes = Arrays.asList(
            BIRTH_YEAR,
            ISSUE_YEAR,
            EXPIRATION_YEAR,
            HEIGHT,
            HAIR_COLOR,
            EYE_COLOR,
            PASSPORT_ID);

    public boolean isValid(Passport passport) {
        List<PassportDataType> types = passport.getPassportData().stream()
                .filter(d -> StringUtils.isNotBlank(d.getValue()))
                .map(DataPair::getPassportDataType)
                .collect(Collectors.toList());

        return types.containsAll(requiredDataTypes);
    }
}
