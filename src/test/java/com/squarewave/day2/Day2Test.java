package com.squarewave.day2;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    private final Day2 day2 = new Day2();

    @Test
    void day2Part1_whenUsingTestData() throws IOException {
        long result = day2.day2Part1("src/test/resources/test-data/test-day2-input.txt");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void day2Part1_whenUsingRealData() throws IOException {
        long result = day2.day2Part1("src/test/resources/data/day2-input.txt");
        assertThat(result).isEqualTo(467);
    }

    @Test
    void day2Part2_whenUsingTestData() throws IOException {
        long result = day2.day2Part2("src/test/resources/test-data/test-day2-input.txt");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void day2Part2_whenUsingRealData() throws IOException {
        long result = day2.day2Part2("src/test/resources/data/day2-input.txt");
        assertThat(result).isEqualTo(441);
    }
}
