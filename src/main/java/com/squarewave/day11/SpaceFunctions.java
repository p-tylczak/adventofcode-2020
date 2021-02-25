package com.squarewave.day11;

import java.util.List;

public class SpaceFunctions {

    public boolean isOccupiable(Space space) {
        return space.getRepresentation() != '.';
    }

    public Space getSpace(List<Space> spaces, Coordinates coordinates) {
        return spaces.stream()
                .filter(s -> {
                    Coordinates c = s.getCoordinates();
                    return c.getX() == coordinates.getX() && c.getY() == coordinates.getY();
                })
                .findFirst()
                .orElse(null);
    }

    public String toString(List<Space> spaces) {
        StringBuilder sb = new StringBuilder();
        int yCounter = 0;

        for (Space space : spaces) {
            if (space.getCoordinates().getY() != yCounter) {
                sb.append('\n');
                yCounter++;
            }

            sb.append(space.getRepresentation());
        }

        return sb.toString();
    }
}
