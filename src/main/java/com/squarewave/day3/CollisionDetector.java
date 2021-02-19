package com.squarewave.day3;

import java.util.List;

public class CollisionDetector {

    public boolean hasCollidedWithTree(Coordinates coordinates, PatternMetadata patternMetadata) {
        List<String> rawLines = patternMetadata.getRawLines();
        String yCoordinateLine = rawLines.get(coordinates.getY() - 1);

        return yCoordinateLine.charAt(coordinates.getX() - 1) == '#';
    }
}
