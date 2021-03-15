package com.squarewave.day12;

import com.squarewave.common.utils.ParserUtils;

import java.util.List;
import java.util.stream.Collectors;

public class InstructionParser {

    private final ParserUtils parserUtils = new ParserUtils();

    public List<Instruction> parse(String fileName) {
        return parserUtils.readLines(fileName).stream()
                .map(l -> {
                    char direction = l.charAt(0);
                    int offset = Integer.parseInt(l.substring(1));

                    return new Instruction(direction, offset);
                })
                .collect(Collectors.toList());
    }
}
