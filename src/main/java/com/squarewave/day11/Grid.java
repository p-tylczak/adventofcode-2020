package com.squarewave.day11;

import java.util.List;

public class Grid {

    private final List<Space> spaces;
    private final int maxX;
    private final int maxY;

    public Grid(List<Space> spaces, int maxX, int maxY) {
        this.spaces = spaces;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
