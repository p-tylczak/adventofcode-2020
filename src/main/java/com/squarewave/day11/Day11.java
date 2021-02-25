package com.squarewave.day11;

import java.util.ArrayList;
import java.util.List;

public class Day11 {

    private final GridParser gridParser = new GridParser();
    private final AdjacentSpaceFinder adjacentSpaceFinder = new AdjacentSpaceFinder();
    private final SpaceFunctions spaceFunctions = new SpaceFunctions();

    public long calculateNumberOfOccupiedSeats(String fileName) {
        Grid grid = gridParser.parse(fileName);

        List<Space> spaces = new ArrayList<>(grid.getSpaces());

        List<Space> result = executeRound(new Coordinates(grid.getMaxX(), grid.getMaxY()), spaces);

        String s = spaceFunctions.toString(spaces);
        System.out.println(s);

        return result.stream()
                .filter(Space::isOccupied)
                .count();
    }

    private List<Space> executeRound(Coordinates size, List<Space> spaces) {
        Rule rule1 = new Rule1();
        Rule rule2 = new Rule2();
        List<Space> newSpaces = new ArrayList<>();
        boolean dirty = false;

        for (Space space : spaces) {
            List<Space> adjacentSpaces = adjacentSpaceFinder.getAdjacentSpaces(size, spaces, space);

            Space afterRuleApplied = !space.isOccupied()
                    ? rule1.apply(space, adjacentSpaces)
                    : rule2.apply(space, adjacentSpaces);

            if (spaceFunctions.isOccupiable(space) && space.isOccupied() != afterRuleApplied.isOccupied()) {
                dirty = true;
            }

            newSpaces.add(afterRuleApplied);
        }

        return dirty
                ? executeRound(size, newSpaces)
                : newSpaces;
    }
}
