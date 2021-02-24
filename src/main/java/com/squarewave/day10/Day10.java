package com.squarewave.day10;

import com.squarewave.common.utils.ParserUtils;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day10 {

    private final ParserUtils parserUtils = new ParserUtils();

    public Integer getResultOfAddition(String fileName) {
        List<Integer> sortedNumbers = parserUtils.readLines(fileName).stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        Integer maxRating = sortedNumbers.get(sortedNumbers.size() - 1) + 3;
        sortedNumbers.add(maxRating);

        Map<Integer, AtomicInteger> counterByDifference = new HashMap<>();
        int joltsRatingToCompare = 0;

        for (Integer n : sortedNumbers) {
            List<Integer> candidates = Arrays.asList(joltsRatingToCompare + 1, joltsRatingToCompare + 2, joltsRatingToCompare + 3);

            if (candidates.contains(n)) {
                int diff = n - joltsRatingToCompare;
                AtomicInteger c = counterByDifference.get(diff);
                if (c == null) {
                    counterByDifference.put(diff, new AtomicInteger(1));
                } else {
                    c.incrementAndGet();
                }

                joltsRatingToCompare = n;
            }
        }

        int countsOfOne = counterByDifference.get(1).get();
        int countsOfThree = counterByDifference.get(3).get();

        return countsOfOne * countsOfThree;
    }

    /*
    Got some help from:
    https://fpvmorais.com/post/advent_of_code_with_power_bi_2020_day10/
    */
    public BigInteger getDistinctNumberOfAdapterArrangements(String fileName) {
        List<Integer> sortedNumbers = parserUtils.readLines(fileName).stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        sortedNumbers.add(0, 0);
        sortedNumbers.add(sortedNumbers.get(sortedNumbers.size() - 1) + 3);

        List<Difference> differences = new ArrayList<>();

        int diff = sortedNumbers.get(1) - sortedNumbers.get(0);
        AtomicInteger counter = new AtomicInteger();
        int groupId;

        for (int i = 1; i < sortedNumbers.size() - 1; i++) {
            int differenceSoFar = sortedNumbers.get(i) - sortedNumbers.get(i - 1);

            if (diff == differenceSoFar) {
                groupId = counter.get();
            } else {
                groupId = counter.incrementAndGet();
                diff = differenceSoFar;
            }

            differences.add(new Difference(differenceSoFar, groupId));
        }

        return differences.stream()
                .filter(d -> d.diff == 1)
                .collect(Collectors.groupingBy(d -> d.group))
                .values().stream()
                .map(List::size)
                .map(this::numberOfCombinations)
                .map(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .orElseThrow();
    }

    private int numberOfCombinations(Integer numberOfOnes) {
        switch (numberOfOnes) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 7;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Difference {
        private final int diff;
        private final int group;

        private Difference(int diff, int group) {
            this.diff = diff;
            this.group = group;
        }
    }

    public BigInteger getDistinctNumberOfAdapterArrangements_BruteForce(String fileName) {
        List<Integer> sortedNumbers = parserUtils.readLines(fileName).stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        return calculateArrangements(sortedNumbers, 0);
    }

    private BigInteger calculateArrangements(List<Integer> sortedNumbers, int toCheck) {
        if (toCheck == sortedNumbers.get(sortedNumbers.size() - 1)) {
            return BigInteger.ONE;
        }

        List<Integer> possibleNextValues = Arrays.asList(toCheck + 1, toCheck + 2, toCheck + 3);

        BigInteger count = BigInteger.ZERO;
        for (int i = 0; i < 3; i++) {
            Integer possibleNextValue = possibleNextValues.get(i);

            if (sortedNumbers.contains(possibleNextValue)) {
                count = count.add(calculateArrangements(sortedNumbers, possibleNextValue));
            }
        }

        return count;
    }
}
