package com.squarewave.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VisibleSpaceFinder {

    private final SpaceFactory spaceFactory = new SpaceFactory();
    private final SpaceFunctions spaceFunctions = new SpaceFunctions();

    public List<Space> getAdjacentSpaces(Coordinates size, List<Space> spaces, Space of) {
        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates( - 1, -1)); // NW
        coordinates.add(new Coordinates(0, -1)); // N
        coordinates.add(new Coordinates(1, -1)); // NE
        coordinates.add(new Coordinates(1, 0)); // E
        coordinates.add(new Coordinates(1, 1)); // SE
        coordinates.add(new Coordinates(0, 1)); // S
        coordinates.add(new Coordinates(-1, 1)); // SW
        coordinates.add(new Coordinates(-1, 0)); // W

        return coordinates.stream()
                .map(towards -> traverse(size, spaces, towards, of))
                .filter(Objects::nonNull)
                .map(spaceFactory::create)
                .collect(Collectors.toList());
    }

    private Space traverse(Coordinates size, List<Space> spaces, Coordinates towards, Space from) {
        Coordinates nextCoordinates = new Coordinates(
                from.getCoordinates().getX() + towards.getX(),
                from.getCoordinates().getY() + towards.getY());

        if (nextCoordinates.getX() < 0 || nextCoordinates.getY() < 0) {
            return null;
        }

        if (nextCoordinates.getX() >= size.getX() || nextCoordinates.getY() >= size.getY()) {
            return null;
        }

        Space space = spaceFunctions.getSpace(spaces, nextCoordinates);
        if (space != null && !spaceFunctions.isOccupiable(space)) {
            return traverse(size, spaces, towards, space);
        }

        return space;
    }
}
