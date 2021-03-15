package com.squarewave.day7;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {

    private final Day7 day7 = new Day7();

    @Test
    void getCombinationCount_whenTestData_shouldReturn4() {
        Long combinationCount = day7.getCombinationCount("src/test/resources/test-data/day7-input.txt");
        assertThat(combinationCount).isEqualTo(4);
    }

    @Test
    void getCombinationCount_whenRealData_shouldReturn179() {
        Long combinationCount = day7.getCombinationCount("src/test/resources/data/day7-input.txt");
        assertThat(combinationCount).isEqualTo(179L);
    }

    @Test
    void getBagCount_whenTestData_shouldReturn32() {
        BigInteger combinationCount = day7.getBagCount("src/test/resources/test-data/day7-input.txt");
        assertThat(combinationCount).isEqualTo(32);
    }

    @Test
    void getBagCount_whenTestDataPart2_shouldReturn126() {
        BigInteger combinationCount = day7.getBagCount("src/test/resources/test-data/day7-input-part2.txt");
        assertThat(combinationCount).isEqualTo(126);
    }

    @Test
    void getBagCount_whenRealData_shouldReturn18925() {
        BigInteger combinationCount = day7.getBagCount("src/test/resources/data/day7-input.txt");
        assertThat(combinationCount).isEqualTo(18925);
    }
}