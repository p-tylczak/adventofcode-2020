package com.squarewave.day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class CommandExecutor {

    private final List<Instruction> instructions;
    private final Stack<Integer> stackPointer = new Stack<>();
    private final Map<Instruction, AtomicInteger> executionCountByInstruction = new HashMap<>();

    private int accumulatorValue = 0;

    public CommandExecutor(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Status execute(Function<CommandExecutor, Boolean> preInstructionHandleInterrupter) {
        instructions.forEach(ins -> executionCountByInstruction.put(ins, new AtomicInteger()));
        stackPointer.push(1);

        while (getCurrentStackPointer() > 0 && getCurrentStackPointer() <= instructions.size()) {
            if (preInstructionHandleInterrupter.apply(this)) {
                return Status.TERMINATED_INTERRUPTED;
            }

            Instruction currentInstruction = getCurrentInstruction();
            handleInstruction(currentInstruction);
            executionCountByInstruction.get(currentInstruction).incrementAndGet();
        }

        return Status.EXIT_NORMALLY;
    }

    public Instruction getCurrentInstruction() {
        return instructions.get(getCurrentStackPointer() - 1);
    }

    public int getAccumulatorValue() {
        return accumulatorValue;
    }

    public Map<Instruction, AtomicInteger> getExecutionCountByInstruction() {
        return executionCountByInstruction;
    }

    private void handleInstruction(Instruction instruction) {
        int nextInstructionPointer = getCurrentStackPointer() + 1;

        switch (instruction.getOperation()) {
            case "acc":
                accumulatorValue += instruction.getArgument();
                break;
            case "jmp":
                nextInstructionPointer += instruction.getArgument() - 1;
                break;
            case "nop":
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Unrecognised instruction %s", instruction.getOperation()));
        }

        stackPointer.push(nextInstructionPointer);
    }

    private int getCurrentStackPointer() {
        return stackPointer.peek();
    }
}
