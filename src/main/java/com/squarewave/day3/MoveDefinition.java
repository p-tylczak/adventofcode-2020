package com.squarewave.day3;

public class MoveDefinition {
    private final int rightMoves;
    private final int downMoves;

    public MoveDefinition(int rightMoves, int downMoves) {
        this.rightMoves = rightMoves;
        this.downMoves = downMoves;
    }

    public int getRightMoves() {
        return rightMoves;
    }

    public int getDownMoves() {
        return downMoves;
    }
}
