package com.squarewave.day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day11Test {

    private final Day11 day11 = new Day11();

    @Test
    void calculateNumberOfOccupiedSeats_whenTestData_shouldReturn37() {
        long result = day11.calculateNumberOfOccupiedSeats("src/test/resources/test-data/test-day11-input.txt");
        assertThat(result).isEqualTo(37);
    }

    @Test
    void calculateNumberOfOccupiedSeats_whenRealData_shouldReturn2427() {
        long result = day11.calculateNumberOfOccupiedSeats("src/test/resources/data/day11-input.txt");
        assertThat(result).isEqualTo(2427);
    }
}