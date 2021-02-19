package com.squarewave.day3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PatternMetadataParserTest {

    @Test
    void parse_whenFirstLineIs3CharacterLongAndHas4Lines_shouldReturnCorrectPatternMetadata() {
        List<String> lines = Arrays.asList("...", ".#.", "...", ".#.");
        PatternMetadata result = new PatternMetadataParser().parse(lines);
        assertThat(result.getRawLines()).isSameAs(lines);
        assertThat(result.getMaxX()).isEqualTo(3);
        assertThat(result.getMaxY()).isEqualTo(4);
    }
}
