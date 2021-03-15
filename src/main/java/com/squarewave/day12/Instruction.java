package com.squarewave.day12;

public class Instruction {

    private final char direction;
    private final int offset;

    public Instruction(char direction, int offset) {
        this.direction = direction;
        this.offset = offset;
    }

    public char getDirection() {
        return direction;
    }

    public int getOffset() {
        return offset;
    }
}
