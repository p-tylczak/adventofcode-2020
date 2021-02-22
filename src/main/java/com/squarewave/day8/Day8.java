package com.squarewave.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {

    private final InstructionsParser instructionsParser = new InstructionsParser();
    private final LoopDetector loopDetector = new LoopDetector();

    public int accValueWhenLoopDetected(String fileName) {
        List<Instruction> instructions = instructionsParser.parse(fileName);
        CommandExecutor commandExecutor = new CommandExecutor(instructions);
        commandExecutor.execute(loopDetector);

        return commandExecutor.getAccumulatorValue();
    }

    public int accValueWhenExecutionCompletes(String fileName) {
        List<Instruction> instructions = instructionsParser.parse(fileName);

        List<Instruction> possibleSwaps = instructions.stream()
                .filter(instruction -> Arrays.asList("nop", "jmp").contains(instruction.getOperation()))
                .collect(Collectors.toList());

        for (Instruction toSwap : possibleSwaps) {
            List<Instruction> newInstructionList = swapInstruction(instructions, toSwap);
            CommandExecutor commandExecutor = new CommandExecutor(newInstructionList);

            Status status = commandExecutor.execute(loopDetector);

            if (status == Status.EXIT_NORMALLY) {
                return commandExecutor.getAccumulatorValue();
            }
        }

        throw new IllegalStateException();
    }

    private List<Instruction> swapInstruction(List<Instruction> instructions, Instruction instructionToSwap) {
        String operation = instructionToSwap.getOperation().equals("nop")
                ? "jmp"
                : "nop";

        Instruction sub = new Instruction(instructionToSwap.getPosition(), operation, instructionToSwap.getArgument());

        ArrayList<Instruction> copy = new ArrayList<>(instructions);
        copy.set(instructionToSwap.getPosition() - 1, sub);

        return copy;
    }
}
