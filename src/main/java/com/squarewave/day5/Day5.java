package com.squarewave.day5;

import com.squarewave.common.utils.ParserUtils;

import java.util.ArrayList;
import java.util.List;

public class Day5 {

    private final ParserUtils parserUtils;

    public Day5(ParserUtils parserUtils) {
        this.parserUtils = parserUtils;
    }

    public List<SeatID> getSeatIDs(String fileName) {
        List<String> lines = parserUtils.readLines(fileName);

        List<SeatID> seatIDS = new ArrayList<>();

        for (String line : lines) {
            Integer row = traverseRows(line, 0, 0, 127);
            Integer column = traverseColumns(line, 7, 0, 7);
            seatIDS.add(new SeatID(String.valueOf((row * 8 + column))));
        }

        return seatIDS;
    }

    private Integer traverseRows(String boardingPassNumber, int currentPosition, int from, int to) {
        if (currentPosition < 7) {
            char characterBeingProcessed = boardingPassNumber.charAt(currentPosition);

            int middle = ((to - from) / 2);
            switch (characterBeingProcessed) {
                case 'F':
                    return traverseRows(boardingPassNumber, currentPosition + 1, from, from + middle);
                case 'B':
                    return traverseRows(boardingPassNumber, currentPosition + 1, from + middle + 1, to);
                default:
                    throw new IllegalArgumentException();
            }
        }

        if (from != to) {
            throw new IllegalStateException("from and to should be equal!");
        }

        return from;
    }

    private Integer traverseColumns(String boardingPassNumber, int currentPosition, int from, int to) {
        if (currentPosition > 6 && currentPosition < 9) {
            char characterBeingProcessed = boardingPassNumber.charAt(currentPosition);

            int middle = ((to - from) / 2);
            switch (characterBeingProcessed) {
                case 'L':
                    return traverseColumns(boardingPassNumber, currentPosition + 1, from, from + middle);
                case 'R':
                    return traverseColumns(boardingPassNumber, currentPosition + 1, from + middle + 1, to);
                default:
                    throw new IllegalArgumentException();
            }
        }

        return boardingPassNumber.charAt(currentPosition) == 'R'
                ? to
                : from;
    }
}
