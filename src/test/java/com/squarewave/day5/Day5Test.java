package com.squarewave.day5;

import com.squarewave.common.utils.ParserUtils;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {

    private final Day5 day5 = new Day5(new ParserUtils());

    @Test
    void getSeatIDs_whenTestData_shouldReturnCorrectValues() {
        List<String> seatIDs = day5.getSeatIDs("src/test/resources/test-data/test-day5-input.txt").stream()
                .map(SeatID::getSeatID)
                .collect(Collectors.toList());

        assertThat(seatIDs).containsExactly("567", "119", "820");
    }

    @Test
    void getSeatIDs_whenRealData_shouldReturnHighestSeatID() {
        Integer seatID = day5.getSeatIDs("src/test/resources/data/day5-input.txt").stream()
                .map(SeatID::getSeatID)
                .map(Integer::parseInt)
                .max(Comparator.naturalOrder())
                .orElse(-1);

        assertThat(seatID).isEqualTo(959);
    }

    @Test
    void getSeatIDs_whenRealData_shouldReturnMySeatIdOf527() {
        List<Integer> seatIDs = day5.getSeatIDs("src/test/resources/data/day5-input.txt").stream()
                .map(SeatID::getSeatID)
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        int min = seatIDs.stream().min(Comparator.naturalOrder()).orElse(-1);
        int max = seatIDs.stream().max(Comparator.naturalOrder()).orElse(-1);

        int expectedSeatId = 0;

        for (int i = min; i <= max; i++) {
            if (!seatIDs.contains(i)) {
                expectedSeatId = i;
            }
        }

        assertThat(expectedSeatId).isEqualTo(527);
    }
}