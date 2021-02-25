package com.squarewave.day11;

public class SpaceFactory {

    public Space create(Coordinates coordinates, char character) {
        switch (character) {
            case '.':
                return new Floor(coordinates, character, false);
            case 'L':
                return new Seat(coordinates, character, false);
            case '#':
                return new Seat(coordinates, character, true);
            default:
                throw new IllegalArgumentException("Unrecognised character: " + character);
        }
    }

    public Space create(Space space) {
        return create(space.getCoordinates(), space.getRepresentation());
    }
}
