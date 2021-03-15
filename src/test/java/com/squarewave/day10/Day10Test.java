package com.squarewave.day10;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class Day10Test {

    private final Day10 day10 = new Day10();

    @Test
    void getResultOfAddition_whenTestData_shouldReturn220() {
        Integer resultOfAddition = day10.getResultOfAddition("src/test/resources/test-data/day10-input.txt");
        assertThat(resultOfAddition).isEqualTo(220);
    }

    @Test
    void getResultOfAddition_whenRealData_shouldReturn2100() {
        Integer resultOfAddition = day10.getResultOfAddition("src/test/resources/data/day10-input.txt");
        assertThat(resultOfAddition).isEqualTo(2100);
    }

    @Test
    void getDistinctNumberOfAdapterArrangements_whenTestData_shouldReturn19208() {
        BigInteger resultOfAddition = day10.getDistinctNumberOfAdapterArrangements("src/test/resources/test-data/day10-input.txt");
        assertThat(resultOfAddition).isEqualTo(19208);
    }

    @Test
    void getDistinctNumberOfAdapterArrangements_whenRealData_shouldReturn16198260678656() {
        BigInteger resultOfAddition = day10.getDistinctNumberOfAdapterArrangements("src/test/resources/data/day10-input.txt");
        assertThat(resultOfAddition).isEqualByComparingTo(new BigInteger("16198260678656"));
    }
}