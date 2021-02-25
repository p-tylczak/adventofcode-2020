package com.squarewave.day11;

public abstract class Space {

    private final Coordinates coordinates;
    private final char representation;
    private final boolean isOccupied;

    public Space(Coordinates coordinates, char representation, boolean isOccupied) {
        this.coordinates = coordinates;
        this.representation = representation;
        this.isOccupied = isOccupied;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
