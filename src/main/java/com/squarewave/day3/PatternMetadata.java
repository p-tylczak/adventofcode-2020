package com.squarewave.day3;

import java.util.List;

public class PatternMetadata {
    private final List<String> rawLines;
    private final int maxX;
    private final int maxY;

    public PatternMetadata(List<String> rawLines, int maxX, int maxY) {
        this.rawLines = rawLines;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public List<String> getRawLines() {
        return rawLines;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
