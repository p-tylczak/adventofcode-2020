package com.squarewave.day11;

import java.util.List;

public class Rule1 implements Rule {

    private final SpaceFactory spaceFactory = new SpaceFactory();
    private final SpaceFunctions spaceFunctions = new SpaceFunctions();

    @Override
    public Space apply(Space space, List<Space> adjacentSpaces) {
        if (!spaceFunctions.isOccupiable(space)) {
            return space;
        }

        boolean adjacentSpacesAreNotOccupied = adjacentSpaces.stream()
                .filter(spaceFunctions::isOccupiable)
                .noneMatch(Space::isOccupied);

        return adjacentSpacesAreNotOccupied
                ? spaceFactory.create(space.getCoordinates(), '#')
                : space;
    }
}
