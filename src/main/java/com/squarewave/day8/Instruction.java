package com.squarewave.day8;

public class Instruction {
    private final int position;
    private final String operation;
    private final int argument;

    public Instruction(int position, String operation, int argument) {
        this.position = position;
        this.operation = operation;
        this.argument = argument;
    }

    public int getPosition() {
        return position;
    }

    public String getOperation() {
        return operation;
    }

    public int getArgument() {
        return argument;
    }
}
