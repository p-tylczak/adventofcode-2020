package com.squarewave.day3;

public class DestinationChecker {

    public boolean hasArrived(Coordinates coordinates, PatternMetadata patternMetadata) {
        return coordinates.getY() == patternMetadata.getMaxY();
    }
}
