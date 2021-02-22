package com.squarewave.day8;

import com.squarewave.common.utils.ParserUtils;

import java.util.List;
import java.util.stream.Collectors;

public class InstructionsParser {

    private final ParserUtils parserUtils = new ParserUtils();

    public List<Instruction> parse(String fileName) {
        return parserUtils.readLines(fileName).stream()
                .map(line -> {
                    String[] parts = line.split(" ");
                    return new Instruction(parts[0], Integer.parseInt(parts[1]));
                })
                .collect(Collectors.toList());
    }

}
