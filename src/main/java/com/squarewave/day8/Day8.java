package com.squarewave.day8;

import java.util.List;

public class Day8 {

    private final InstructionsParser instructionsParser = new InstructionsParser();
    private final LoopDetector loopDetector = new LoopDetector();

    public int accValueWhenLoopDetected(String fileName) {
        List<Instruction> instructions = instructionsParser.parse(fileName);
        CommandExecutor commandExecutor = new CommandExecutor(instructions);
        commandExecutor.execute(loopDetector);

        return commandExecutor.getAccumulatorValue();
    }
}
