package com.squarewave.day13;

import com.squarewave.common.utils.ParserUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day13 {
    private final ParserUtils parserUtils = new ParserUtils();

    public int findResult(String fileName) {
        List<String> lines = parserUtils.readLines(fileName);

        int earliestDepartureTimestamp = Integer.parseInt(lines.get(0));
        List<Integer> busIds = Arrays.stream(lines.get(1).split(","))
                .filter(id -> !id.equals("x"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, Integer> nextDepartureTimestampByBusId = new HashMap<>();

        for (int busId : busIds) {
            int nextDepartureTimestamp = calculateNextDepartureTimestampAfter(earliestDepartureTimestamp, 0, busId);
            nextDepartureTimestampByBusId.put(busId, nextDepartureTimestamp);
        }

        Map.Entry<Integer, Integer> next = nextDepartureTimestampByBusId.entrySet().stream()
                .reduce((e1, e2) -> e1.getValue() < e2.getValue() ? e1 : e2)
                .orElseThrow();

        return (next.getValue() - earliestDepartureTimestamp) * next.getKey();
    }

    /* with help from https://github.com/cs-cordero/advent_of_code/blob/master/rs/2020/day13/src/main.rs */
    public long findTimeT(String fileName) {
        List<String> lines = parserUtils.readLines(fileName);

        List<String> busIds = Arrays.asList(lines.get(1).split(","));

        List<Integer> offsets = getOffsets(busIds);
        var offsetByBusId = getOffsetsByBusId(offsets, busIds);

        long iterator = 1;
        long increment = 1;

        for (var entry : offsetByBusId.entrySet()) {
            while ((iterator + entry.getValue()) % entry.getKey() != 0) {
                iterator += increment;
            }

            increment *= entry.getKey();
        }

        return iterator;
    }

    private Map<Long, Integer> getOffsetsByBusId(List<Integer> offsets, List<String> busIds) {
        var map = new HashMap<Long, Integer>();

        for (int i = 0; i < busIds.size(); i++) {
            if (!busIds.get(i).equals("x")) {
                map.put(Long.parseLong(busIds.get(i)), offsets.get(i));
            }
        }

        return map;
    }

    private List<Integer> getOffsets(List<String> busIds) {
        AtomicInteger counter = new AtomicInteger(0);

        return busIds.stream()
                .map(busId -> {
                    int v = counter.getAndIncrement();

                    if (busId.equals("x")) {
                        return 0;
                    } else {
                        return v;
                    }
                })
                .collect(Collectors.toList());
    }

    private int calculateNextDepartureTimestampAfter(int min, int departureTimestamp, int departureInterval) {
        do {
            departureTimestamp += departureInterval;
        } while (departureTimestamp < min);

        return departureTimestamp;
    }
}
