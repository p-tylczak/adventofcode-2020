package com.squarewave.day12;

import org.apache.commons.lang3.tuple.Pair;

import java.util.concurrent.atomic.AtomicInteger;

public class Waypoint {

    private Pair<AtomicInteger, AtomicInteger> waypointPosition;

    public Waypoint(Pair<AtomicInteger, AtomicInteger> waypointPosition) {
        this.waypointPosition = waypointPosition;
    }

    public void move(Instruction instruction) {
        switch (instruction.getDirection()) {
            case 'N':
                waypointPosition.getRight().addAndGet(instruction.getOffset());
                return;
            case 'S':
                waypointPosition.getRight().addAndGet(-instruction.getOffset());
                return;
            case 'E':
                waypointPosition.getLeft().addAndGet(instruction.getOffset());
                return;
            case 'W':
                waypointPosition.getLeft().addAndGet(-instruction.getOffset());
                return;
            case 'L':
            case 'R':
                waypointPosition = rewriteByAngleLeft(waypointPosition, instruction.getOffset(), instruction.getDirection());
                return;
            default:
                throw new IllegalArgumentException("Unrecognised direction: " + instruction.getDirection());
        }
    }

    public Pair<AtomicInteger, AtomicInteger> getWaypointPosition() {
        return waypointPosition;
    }

    private Pair<AtomicInteger, AtomicInteger> rewriteByAngleLeft(Pair<AtomicInteger, AtomicInteger> waypoint,
                                                                  int offset,
                                                                  char direction) {
        switch (flipIfLeft(direction, offset)) {
            case 90:
                return Pair.of(waypoint.getRight(), new AtomicInteger(-waypoint.getLeft().get()));
            case 180:
                return Pair.of(new AtomicInteger(-waypoint.getLeft().get()), new AtomicInteger(-waypoint.getRight().get()));
            case 270:
                return Pair.of(new AtomicInteger(-waypoint.getRight().get()), new AtomicInteger(waypoint.getLeft().get()));
            default:
                throw new IllegalArgumentException("Unrecognised angle: [" + direction + "] " + offset);
        }
    }

    private int flipIfLeft(char direction, int offset) {
        return direction == 'L'
                ? flipAngles(offset)
                : offset;
    }

    private int flipAngles(int offset) {
        switch (offset) {
            case 90:
                return 270;
            case 270:
                return 90;
            default:
                return offset;
        }
    }
}
