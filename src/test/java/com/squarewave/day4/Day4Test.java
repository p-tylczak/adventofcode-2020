package com.squarewave.day4;

import com.squarewave.common.utils.ParserUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

    private final Day4 day4 = new Day4(
            new PassportDataParser(new ParserUtils()),
            new ParserUtils());

    @Test
    void calculateValidPassports_whenSimpleValidatorTestData_shouldReturn2() {
        long result = day4.calculateNumberOfValidPassports(
                "src/test/resources/test-data/test-day4-input.txt",
                new PassportValidator());

        assertThat(result).isEqualTo(2);
    }

    @Test
    void calculateValidPassports_whenSimpleValidatorAndRealData_shouldReturn226() {
        long result = day4.calculateNumberOfValidPassports(
                "src/test/resources/data/day4-input.txt",
                new PassportValidator());

        assertThat(result).isEqualTo(226L);
    }

    @Test
    void calculateValidPassports_whenStrictValidatorRealData_shouldReturn2333333() {
        long result = day4.calculateNumberOfValidPassports(
                "src/test/resources/data/day4-input.txt",
                new StrictPassportValidator());

        assertThat(result).isEqualTo(160);
    }
}
