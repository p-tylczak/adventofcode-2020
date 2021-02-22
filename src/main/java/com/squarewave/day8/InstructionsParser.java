package com.squarewave.day8;

import com.squarewave.common.utils.ParserUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InstructionsParser {

    private final ParserUtils parserUtils = new ParserUtils();

    public List<Instruction> parse(String fileName) {
        AtomicInteger counter = new AtomicInteger();
        return parserUtils.readLines(fileName).stream()
                .map(line -> {
                    String[] parts = line.split(" ");
                    return new Instruction(counter.incrementAndGet(), parts[0], Integer.parseInt(parts[1]));
                })
                .collect(Collectors.toList());
    }
}
