package com.squarewave.day8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {
    private final Day8 day8 = new Day8();

    @Test
    void accValueWhenLoopDetected_whenTestData_shouldReturn5() {
        int accValue = day8.accValueWhenLoopDetected("src/test/resources/test-data/day8-input.txt");
        assertThat(accValue).isEqualTo(5);
    }

    @Test
    void getCombinationCount_whenRealData_shouldReturn1782() {
        int accValue = day8.accValueWhenLoopDetected("src/test/resources/data/day8-input.txt");
        assertThat(accValue).isEqualTo(1782);
    }

    @Test
    void accValueWhenExecutionCompletes_whenTestData_shouldReturn8() {
        int accValue = day8.accValueWhenExecutionCompletes("src/test/resources/test-data/day8-input.txt");
        assertThat(accValue).isEqualTo(8);
    }

    @Test
    void accValueWhenExecutionCompletes_whenRealData_shouldReturn8() {
        int accValue = day8.accValueWhenExecutionCompletes("src/test/resources/data/day8-input.txt");
        assertThat(accValue).isEqualTo(797);
    }
}
