package com.squarewave.day12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day12Test {

    private final Day12 day12 = new Day12();

    @Test
    void manhattanDistance_whenTestData_shouldReturn25() {
        Integer result = day12.manhattanDistance("src/test/resources/test-data/test-day12-input.txt");
        assertThat(result).isEqualTo(25);
    }

    @Test
    void manhattanDistance_whenRealData_shouldReturn1601() {
        Integer result = day12.manhattanDistance("src/test/resources/data/day12-input.txt");
        assertThat(result).isEqualTo(1601);
    }

    @Test
    void manhattanDistancePart2_whenTestData_shouldReturn286() {
        Integer result = day12.manhattanDistancePart2("src/test/resources/test-data/test-day12-input.txt");
        assertThat(result).isEqualTo(286);
    }

    @Test
    void manhattanDistancePart2_whenRealData_shouldReturn13340() {
        Integer result = day12.manhattanDistancePart2("src/test/resources/data/day12-input.txt");
        assertThat(result).isEqualTo(13340);
    }
}