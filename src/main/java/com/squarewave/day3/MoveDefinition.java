package com.squarewave.day3;

public class MoveDefinition {
    private final int rightMoves;
    private final int downMoves;
    private final int leftMoves;

    public MoveDefinition(int rightMoves, int downMoves, int leftMoves) {
        this.rightMoves = rightMoves;
        this.downMoves = downMoves;
        this.leftMoves = leftMoves;
    }

    public int getRightMoves() {
        return rightMoves;
    }

    public int getDownMoves() {
        return downMoves;
    }

    public int getLeftMoves() {
        return leftMoves;
    }
}
