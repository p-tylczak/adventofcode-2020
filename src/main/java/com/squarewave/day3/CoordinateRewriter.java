package com.squarewave.day3;

public class CoordinateRewriter {

    public Coordinates rewrite(Coordinates coordinates, PatternMetadata patternMetadata) {
        int newX = coordinates.getX();
        if (coordinates.getX() > patternMetadata.getMaxX()) {
            newX -= patternMetadata.getMaxX();
        }

        return new Coordinates(newX, coordinates.getY());
    }

}
