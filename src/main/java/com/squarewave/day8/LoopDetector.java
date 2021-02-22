package com.squarewave.day8;

import java.util.function.Function;

public class LoopDetector implements Function<CommandExecutor, Boolean> {

    @Override
    public Boolean apply(CommandExecutor commandExecutor) {
        return commandExecutor.getExecutionCountByInstruction()
                .get(commandExecutor.getCurrentInstruction())
                .get() >= 1;
    }
}
