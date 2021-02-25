package com.squarewave.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdjacentSpaceFinder {

    private final SpaceFactory spaceFactory = new SpaceFactory();
    private final SpaceFunctions spaceFunctions = new SpaceFunctions();

    public List<Space> getAdjacentSpaces(Coordinates size, List<Space> spaces, Space of) {
        int x = of.getCoordinates().getX();
        int y = of.getCoordinates().getY();
        int maxX = size.getX();
        int maxY = size.getY();

        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(new Coordinates(x - 1, y - 1)); // NW
        coordinates.add(new Coordinates(x, y - 1)); // N
        coordinates.add(new Coordinates(x + 1, y - 1)); // NE
        coordinates.add(new Coordinates(x + 1, y)); // E
        coordinates.add(new Coordinates(x + 1, y + 1)); // SE
        coordinates.add(new Coordinates(x, y + 1)); // S
        coordinates.add(new Coordinates(x - 1, y + 1)); // SW
        coordinates.add(new Coordinates(x - 1, y)); // W

        return coordinates.stream()
                .filter(c -> c.getX() >= 0 && c.getX() < maxX
                        && c.getY() >= 0 && c.getY() < maxY)
                .map(c -> spaceFunctions.getSpace(spaces, c))
                .map(spaceFactory::create)
                .collect(Collectors.toList());
    }
}
