package com.squarewave.day11;

import com.squarewave.common.utils.ParserUtils;

import java.util.ArrayList;
import java.util.List;

public class GridParser {

    private final ParserUtils parserUtils = new ParserUtils();
    private final SpaceFactory spaceFactory = new SpaceFactory();

    public Grid parse(String fileName) {
        int xCounter = 0;
        int yCounter = 0;

        List<Space> spaces = new ArrayList<>();

        for (char c : parserUtils.readFileContent(fileName).toCharArray()) {
            if (String.valueOf(c).equals(ParserUtils.NEW_LINE)) {
                yCounter++;
                xCounter = 0;
                continue;
            }

            Coordinates coordinates = new Coordinates(xCounter, yCounter);
            Space space = spaceFactory.create(coordinates, c);
            spaces.add(space);

            xCounter++;
        }

        // plus one as there is no new line in the input after the data
        return new Grid(spaces, xCounter, yCounter + 1);
    }
}
