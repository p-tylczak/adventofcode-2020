package com.squarewave.day12;

import org.apache.commons.lang3.tuple.Pair;

import java.util.concurrent.atomic.AtomicInteger;

public class Ship {

    private int currentDirectionAngle;
    private Pair<AtomicInteger, AtomicInteger> coordinates;

    public Ship(int currentDirectionAngle, Pair<AtomicInteger, AtomicInteger> coordinates) {
        this.currentDirectionAngle = currentDirectionAngle;
        this.coordinates = coordinates;
    }

    public void move(Instruction instruction) {
        char direction = rewriteIfForward(instruction);
        switch (direction) {
            case 'N':
                coordinates.getRight().addAndGet(-instruction.getOffset());
                break;
            case 'S':
                coordinates.getRight().addAndGet(instruction.getOffset());
                break;
            case 'E':
                coordinates.getLeft().addAndGet(instruction.getOffset());
                break;
            case 'W':
                coordinates.getLeft().addAndGet(-instruction.getOffset());
                break;
            case 'L':
                currentDirectionAngle -= instruction.getOffset();
                currentDirectionAngle = normalized(currentDirectionAngle);
                break;
            case 'R':
                currentDirectionAngle += instruction.getOffset();
                currentDirectionAngle = normalized(currentDirectionAngle);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void moveByWaypoint(Instruction instruction, Waypoint waypoint) {
        if (instruction.getDirection() != 'F') {
            waypoint.move(instruction);
        } else {
            int count = instruction.getOffset();
            AtomicInteger wx = waypoint.getWaypointPosition().getLeft();
            AtomicInteger wy = waypoint.getWaypointPosition().getRight();

            int sx = coordinates.getLeft().get();
            int sy = coordinates.getRight().get();

            coordinates = Pair.of(
                    new AtomicInteger(sx + wx.get() * count),
                    new AtomicInteger(sy + wy.get() * count));
        }
    }

    private int normalized(int currentDirectionAngle) {
        if (currentDirectionAngle >= 0 && currentDirectionAngle < 360)
            return currentDirectionAngle;

        return currentDirectionAngle >= 360
                ? normalized(currentDirectionAngle - 360)
                : normalized(currentDirectionAngle + 360);
    }

    public Pair<AtomicInteger, AtomicInteger> getCoordinates() {
        return coordinates;
    }

    private char rewriteIfForward(Instruction instruction) {
        if (instruction.getDirection() == 'F') {
            switch (Math.abs(currentDirectionAngle)) {
                case 0:
                    return 'N';
                case 90:
                    return 'E';
                case 180:
                    return 'S';
                case 270:
                    return 'W';
                default:
                    throw new IllegalArgumentException("Unrecognised direction: " + currentDirectionAngle);
            }
        }

        return instruction.getDirection();
    }
}
