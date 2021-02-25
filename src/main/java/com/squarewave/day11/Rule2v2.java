package com.squarewave.day11;

import java.util.List;

public class Rule2v2 implements Rule {

    private final SpaceFunctions spaceFunctions = new SpaceFunctions();
    private final SpaceFactory spaceFactory = new SpaceFactory();

    @Override
    public Space apply(Space space, List<Space> adjacentSpaces) {
        if (!spaceFunctions.isOccupiable(space)) {
            return space;
        }

        long numberOfAdjacentOccupiedSpaces = adjacentSpaces.stream()
                .filter(spaceFunctions::isOccupiable)
                .filter(Space::isOccupied)
                .count();

        return numberOfAdjacentOccupiedSpaces >= 5
                ? spaceFactory.create(space.getCoordinates(), 'L')
                : space;
    }
}
