package com.squarewave.day12;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day12 {

    private final InstructionParser instructionParser = new InstructionParser();

    public Integer manhattanDistance(String fileName) {
        List<Instruction> instructions = instructionParser.parse(fileName);

        Ship ship = new Ship(90, Pair.of(new AtomicInteger(), new AtomicInteger()));

        for (Instruction instruction : instructions) {
            ship.move(instruction);
        }

        return Math.abs(ship.getCoordinates().getLeft().get()
                + ship.getCoordinates().getRight().get());
    }

    public Integer manhattanDistancePart2(String fileName) {
        List<Instruction> instructions = instructionParser.parse(fileName);

        Ship ship = new Ship(90, Pair.of(new AtomicInteger(), new AtomicInteger()));
        Waypoint waypoint = new Waypoint(Pair.of(new AtomicInteger(10), new AtomicInteger(1)));

        for (Instruction instruction : instructions) {
            ship.moveByWaypoint(instruction, waypoint);
        }

        return Math.abs(ship.getCoordinates().getLeft().get())
                + Math.abs(ship.getCoordinates().getRight().get());
    }
}
