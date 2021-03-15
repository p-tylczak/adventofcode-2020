package com.squarewave.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {

    private final Day1 day1 = new Day1();

    @Test
    void day1Part1_whenUsingTestData() throws IOException {
        int result = day1.day1Part1("src/test/resources/test-data/day1-input.txt");
        assertThat(result).isEqualTo(514579);
    }

    @Test
    void day1Part1_whenUsingRealData() throws IOException {
        int result = day1.day1Part1("src/test/resources/data/day1-input.txt");
        assertThat(result).isEqualTo(1014171);
    }

    @Test
    void day1Part2_whenUsingTestData() throws IOException {
        int result = day1.day1Part2("src/test/resources/test-data/day1-input.txt");
        assertThat(result).isEqualTo(241861950);
    }

    @Test
    void day1Part2_whenUsingRealData() throws IOException {
        int result = day1.day1Part2("src/test/resources/data/day1-input.txt");
        assertThat(result).isEqualTo(46584630);
    }
}
