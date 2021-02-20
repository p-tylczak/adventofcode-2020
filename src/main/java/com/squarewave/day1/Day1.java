package com.squarewave.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    public int day1Part1(String fileName) throws IOException {
        List<Integer> integers = Files.readAllLines(Paths.get(fileName)).stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < integers.size() - 1; i++) {
            for (int j = 1; j < integers.size(); j++) {
                Integer i1 = integers.get(i);
                Integer i2 = integers.get(j);

                if (i1 + i2 == 2020) {
                    int product = i1 * i2;
                    System.out.println("FOUND: " + i1 + " : " + i2 + " -> " + product);
                    return product;
                }
            }
        }

        throw new IllegalStateException();
    }

    public int day1Part2(String fileName) throws IOException {
        List<Integer> integers = Files.readAllLines(Paths.get(fileName)).stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < integers.size() - 2; i++) {
            for (int j = 1; j < integers.size() - 1; j++) {
                for (int k = 2; k < integers.size(); k++) {
                    Integer i1 = integers.get(i);
                    Integer i2 = integers.get(j);
                    Integer i3 = integers.get(k);

                    if (i1 + i2 + i3 == 2020) {
                        int product = i1 * i2 * i3;
                        System.out.println("FOUND: " + i1 + " : " + i2 + " : " + i3 + " -> " + product);
                        return product;
                    }
                }
            }
        }

        throw new IllegalStateException();
    }
}
