package com.squarewave.day3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {

    private final Day3 day3 = new Day3(
            new PatternMetadataParser(),
            new CheapTobogganNavigator(),
            new CollisionDetector(),
            new DestinationChecker(),
            new CoordinateRewriter());

    @Test
    void part1_whenUsingTestDataAndMoving3RightAnd1Down_shouldHit7Trees() throws IOException {
        MoveDefinition moveDefinition = new MoveDefinition(3, 1);
        long result = day3.part1("src/test/resources/test-data/day3-input.txt", moveDefinition);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void part1_whenUsingRealDataAndMoving3RightAnd1Down_shouldHit173Trees() throws IOException {
        MoveDefinition moveDefinition = new MoveDefinition(3, 1);
        long result = day3.part1("src/test/resources/data/day3-input.txt", moveDefinition);
        assertThat(result).isEqualTo(173);
    }

    @Test
    void part2_whenUsingTestDataAndMoving1RightAnd1Down_shouldHit2Trees() throws IOException {
        MoveDefinition moveDefinition = new MoveDefinition(1, 1);
        long result = day3.part1("src/test/resources/test-data/day3-input.txt", moveDefinition);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void part2_whenUsingTestDataAndMoving5RightAnd1Down_shouldHit3Trees() throws IOException {
        MoveDefinition moveDefinition = new MoveDefinition(5, 1);
        long result = day3.part1("src/test/resources/test-data/day3-input.txt", moveDefinition);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void part2_whenUsingTestDataAndMoving7RightAnd1Down_shouldHit4Trees() throws IOException {
        MoveDefinition moveDefinition = new MoveDefinition(7, 1);
        long result = day3.part1("src/test/resources/test-data/day3-input.txt", moveDefinition);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void part2_whenUsingTestDataAndMoving1RightAnd2Down_shouldHit2Trees() throws IOException {
        MoveDefinition moveDefinition = new MoveDefinition(1, 2);
        long result = day3.part1("src/test/resources/test-data/day3-input.txt", moveDefinition);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void part2_whenUsingTestDataAndMovingMultipleTimes_shouldProduce336PotentialTreeHits() throws IOException {
        List<MoveDefinition> moveDefinitions = Arrays.asList(
                new MoveDefinition(1, 1),
                new MoveDefinition(3, 1),
                new MoveDefinition(5, 1),
                new MoveDefinition(7, 1),
                new MoveDefinition(1, 2));

        long total = 1;

        for (MoveDefinition moveDefinition : moveDefinitions) {
            total *= day3.part1("src/test/resources/test-data/day3-input.txt", moveDefinition);
        }

        assertThat(total).isEqualTo(336);
    }

    @Test
    void part2_whenUsingRealDataAndMovingMultipleTimes_shouldProduceXPotentialTreeHits() throws IOException {
        List<MoveDefinition> moveDefinitions = Arrays.asList(
                new MoveDefinition(1, 1),
                new MoveDefinition(3, 1),
                new MoveDefinition(5, 1),
                new MoveDefinition(7, 1),
                new MoveDefinition(1, 2));

        long total = 1;

        for (MoveDefinition moveDefinition : moveDefinitions) {
            total *= day3.part1("src/test/resources/data/day3-input.txt", moveDefinition);
        }

        assertThat(total).isEqualTo(4385176320L);
    }
}
