package com.squarewave.day3;

public class CheapTobogganNavigator {

    public Coordinates move(Coordinates currentCoordinates, MoveDefinition moveDefinition) {
        return new Coordinates(
                currentCoordinates.getX() + moveDefinition.getRightMoves(),
                currentCoordinates.getY() + moveDefinition.getDownMoves());
    }

}
