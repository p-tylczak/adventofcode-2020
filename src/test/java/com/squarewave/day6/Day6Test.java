package com.squarewave.day6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {

    private Day6 day6;

    @BeforeEach
    void setup() {
        day6 = new Day6();
    }

    @Test
    void getCountForAllGroups_whenTestData_shouldReturn11() {
        BigInteger countForAllGroups = day6.getCountForAllGroups("src/test/resources/test-data/day6-input.txt");
        assertThat(countForAllGroups).isEqualTo(11);
    }

    @Test
    void getCountForAllGroups_whenRealData_shouldReturnXX() {
        BigInteger countForAllGroups = day6.getCountForAllGroups("src/test/resources/data/day6-input.txt");
        assertThat(countForAllGroups).isEqualTo(6387);
    }

    @Test
    void getCountForAllGroupsPart2_whenTestData_shouldReturn6() {
        BigInteger countForAllGroups = day6.getCountForAllGroupsPart2("src/test/resources/test-data/day6-input.txt");
        assertThat(countForAllGroups).isEqualTo(6);
    }

    @Test
    void getCountForAllGroupsPart2_whenRealData_shouldReturn11() {
        BigInteger countForAllGroups = day6.getCountForAllGroupsPart2("src/test/resources/data/day6-input.txt");
        assertThat(countForAllGroups).isEqualTo(3039);
    }
}