package com.squarewave.day8;

public class Day8 {

    private final InstructionsParser instructionsParser = new InstructionsParser();
    private final LoopDetector loopDetector = new LoopDetector();

    public int accValueWhenLoopDetected(String fileName) {
        CommandExecutor commandExecutor = new CommandExecutor(instructionsParser.parse(fileName));
        commandExecutor.execute(loopDetector);

        return commandExecutor.getAccumulatorValue();
    }
}
