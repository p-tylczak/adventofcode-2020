package com.squarewave.day9;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class Day9Test {

    private final Day9 day9 = new Day9();

    @Test
    void getCorruptedData_whenTestDataAndPreambleSize5_shouldReturn127() {
        BigInteger result = day9.getCorruptedData(5, "src/test/resources/test-data/test-day9-input-preamble-5.txt");
        assertThat(result).isEqualTo(127);
    }

    @Test
    void getCorruptedData_whenRealData_shouldReturn675280050() {
        BigInteger result = day9.getCorruptedData(25, "src/test/resources/data/day9-input.txt");
        assertThat(result).isEqualTo(675280050);
    }

    @Test
    void getEncryptionWeakness_whenTestDataAndNumberToCheckIs127_shouldReturn62() {
        BigInteger result = day9.getEncryptionWeakness(BigInteger.valueOf(127), "src/test/resources/test-data/test-day9-input-preamble-5.txt");
        assertThat(result).isEqualTo(62);
    }

    @Test
    void getEncryptionWeakness_whenRealDataAndNumberToCheckIs675280050_shouldReturnX() {
        BigInteger result = day9.getEncryptionWeakness(BigInteger.valueOf(675280050), "src/test/resources/data/day9-input.txt");
        assertThat(result).isEqualTo(96081673);
    }
}
