package com.squarewave.day3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {

    private Day3 day3 = new Day3();

    @Test
    void day3Part1_whenUsingTestData() throws IOException {
        long result = day3.day3Part1("src/test/resources/test-data/test-day3-input.txt");
        assertThat(result).isEqualTo(7);
    }

    @Test
    void day3Part1_whenUsingRealData() throws IOException {
        long result = day3.day3Part1("src/test/resources/data/day3-input.txt");
        assertThat(result).isEqualTo(666);
    }

    @Test
    void day3Part2_whenUsingTestData() throws IOException {
        long result = day3.day3Part2("src/test/resources/test-data/test-day3-input.txt");
        assertThat(result).isEqualTo(666);
    }

    @Test
    void day3Part2_whenUsingRealData() throws IOException {
        long result = day3.day3Part2("src/test/resources/data/day3-input.txt");
        assertThat(result).isEqualTo(666);
    }
}
