package com.squarewave.day8;

import java.util.function.Function;

public class LoopDetector implements Function<CommandExecutor, Boolean> {

    @Override
    public Boolean apply(CommandExecutor commandExecutor) {
        Instruction currentInstruction = commandExecutor.getInstructions().get(commandExecutor.getStackPointer() - 1);
        return commandExecutor.getExecutionCountByInstruction().get(currentInstruction).get() >= 1;
    }
}
