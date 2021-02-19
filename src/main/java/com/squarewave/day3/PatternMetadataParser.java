package com.squarewave.day3;

import java.util.List;

public class PatternMetadataParser {
    public PatternMetadata parse(List<String> lines) {
        return new PatternMetadata(lines, lines.get(0).length(), lines.size());
    }
}
