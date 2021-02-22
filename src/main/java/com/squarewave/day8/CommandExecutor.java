package com.squarewave.day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class CommandExecutor {

    private final List<Instruction> instructions;
    private int stackPointer = 0;
    private int accumulatorValue = 0;
    private final Map<Instruction, AtomicInteger> executionCountByInstruction = new HashMap<>();

    public CommandExecutor(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void execute(Function<CommandExecutor, Boolean> preHandleCallback) {
        instructions.forEach(ins -> executionCountByInstruction.put(ins, new AtomicInteger()));
        Instruction currentInstruction;

        stackPointer = 1;

        while (true) {
            currentInstruction = instructions.get(stackPointer - 1);

            if (preHandleCallback.apply(this)) {
                break;
            }

            handleInstruction(currentInstruction);
            executionCountByInstruction.get(currentInstruction).incrementAndGet();
        }
    }

    private void handleInstruction(Instruction instruction) {
        switch (instruction.getOperation()) {
            case "acc":
                accumulatorValue += instruction.getArgument();
                break;
            case "jmp":
                stackPointer += instruction.getArgument() - 1;
                break;
            case "nop":
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Unrecognised instruction %s", instruction.getOperation()));

        }

        stackPointer++;
    }

    public int getStackPointer() {
        return stackPointer;
    }

    public int getAccumulatorValue() {
        return accumulatorValue;
    }

    public Map<Instruction, AtomicInteger> getExecutionCountByInstruction() {
        return executionCountByInstruction;
    }
}
