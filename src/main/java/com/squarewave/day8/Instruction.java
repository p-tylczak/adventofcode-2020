package com.squarewave.day8;

public class Instruction {
    private final String operation;
    private final int argument;

    public Instruction(String operation, int argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public String getOperation() {
        return operation;
    }

    public int getArgument() {
        return argument;
    }
}
