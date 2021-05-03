package com.squarewave.day13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day13Test {

    private final Day13 day13 = new Day13();

    @Test
    void findResult_whenTestData_shouldReturn295() {
        Integer result = day13.findResult("src/test/resources/test-data/day13-input.txt");
        assertThat(result).isEqualTo(295);
    }

    @Test
    void findResult_whenRealData_shouldReturn3035() {
        Integer result = day13.findResult("src/test/resources/data/day13-input.txt");
        assertThat(result).isEqualTo(3035);
    }

    @Test
    void findTimeT_whenTestData_shouldReturn1068781() {
        Long result = day13.findTimeT("src/test/resources/test-data/day13-input.txt");
        assertThat(result).isEqualTo(1068781L);
    }

    @Test
    void findTimeT_whenRealData_shouldReturn725169163285238() {
        Long result = day13.findTimeT("src/test/resources/data/day13-input.txt");
        assertThat(result).isEqualTo(725169163285238L);
    }
}