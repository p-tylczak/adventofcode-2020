package com.squarewave.day9;

import com.squarewave.common.utils.ParserUtils;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class Day9 {

    private final ParserUtils parserUtils = new ParserUtils();

    public BigInteger getCorruptedData(int preambleSize, String fileName) {
        List<BigInteger> numbers = readNumbers(fileName);
        return calculateInvalidData(numbers, 0, preambleSize);
    }

    public BigInteger getEncryptionWeakness(BigInteger numberToCheck, String fileName) {
        List<BigInteger> numbers = readNumbers(fileName);
        return calculateSum(numbers, numberToCheck);
    }

    private List<BigInteger> readNumbers(String fileName) {
        return parserUtils.readLines(fileName).stream()
                .map(BigInteger::new)
                .collect(Collectors.toList());
    }

    private BigInteger calculateInvalidData(List<BigInteger> numbers, int offset, int preambleSize) {
        List<BigInteger> subList = numbers.subList(offset, offset + preambleSize);

        BigInteger numberToCheck = numbers.get(offset + preambleSize);

        for (int i = 0; i < subList.size() - 1; i++) {
            for (int j = i + 1; j < subList.size(); j++) {
                BigInteger sum = subList.get(i).add(subList.get(j));
                if (numberToCheck.equals(sum)) {
                    return calculateInvalidData(numbers, offset + 1, preambleSize);
                }
            }
        }

        return numberToCheck;
    }

    private BigInteger calculateSum(List<BigInteger> numbers, BigInteger numberToCheck) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                List<BigInteger> subList = numbers.subList(i, j + 1);

                BigInteger sum = subList.stream()
                        .reduce(BigInteger::add)
                        .orElseThrow();

                if (numberToCheck.compareTo(sum) != 0) {
                    continue;
                }

                BigInteger min = subList.stream().min(BigInteger::compareTo).orElseThrow();
                BigInteger max = subList.stream().max(BigInteger::compareTo).orElseThrow();

                return min.add(max);
            }
        }

        throw new IllegalStateException();
    }
}
