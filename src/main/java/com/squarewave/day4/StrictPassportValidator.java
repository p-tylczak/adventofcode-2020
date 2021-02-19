package com.squarewave.day4;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.squarewave.day4.PassportDataType.BIRTH_YEAR;
import static com.squarewave.day4.PassportDataType.EXPIRATION_YEAR;
import static com.squarewave.day4.PassportDataType.EYE_COLOR;
import static com.squarewave.day4.PassportDataType.HAIR_COLOR;
import static com.squarewave.day4.PassportDataType.HEIGHT;
import static com.squarewave.day4.PassportDataType.ISSUE_YEAR;
import static com.squarewave.day4.PassportDataType.PASSPORT_ID;

public class StrictPassportValidator {

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
                .filter(this::validate)
                .map(DataPair::getPassportDataType)
                .collect(Collectors.toList());

        return types.containsAll(requiredDataTypes);
    }

    private boolean validate(DataPair dataPair) {
        int year;
        String value = dataPair.getValue();

        switch (dataPair.getPassportDataType()) {
            case BIRTH_YEAR:
                year = Integer.parseInt(value);
                return value.length() == 4
                        && year >= 1920 && year <= 2002;
            case ISSUE_YEAR:
                year = Integer.parseInt(value);
                return value.length() == 4
                        && year >= 2010 && year <= 2020;
            case EXPIRATION_YEAR:
                year = Integer.parseInt(value);
                return value.length() == 4
                        && year >= 2020 && year <= 2030;
            case HEIGHT:
                boolean valid = Pattern.compile("^([0-9]+[cm|in]+)$").matcher(value).matches();
                if (!valid) return false;

                int height = Integer.parseInt(value.substring(0, value.length() - 2));
                return value.endsWith("cm")
                        ? height >= 150 && height <= 193
                        : height >= 59 && height <= 76;
            case HAIR_COLOR:
                return Pattern.compile("^#([a-fA-F0-9]{6})$").matcher(value).matches();
            case EYE_COLOR:
                return Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
                        .contains(value);
            case PASSPORT_ID:
                return Pattern.compile("^([0-9]{9})$").matcher(value).matches();
            case COUNTRY_ID:
                return true;
            default:
                throw new IllegalArgumentException(
                        String.format(
                                "Passport data type not recognised: '%s'", dataPair.getPassportDataType()));
        }
    }
}
