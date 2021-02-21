package com.squarewave.day7;

import java.util.*;
import java.util.stream.Collectors;

public class BagPolicyParser {

    public List<Bag> parse(List<String> lines) {
        return lines.stream()
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private Bag parseLine(String line) {
        String[] parts = line.split(" bags contain ");

        String bagColour = parts[0];
        Bag bag = new Bag(bagColour);

        boolean hasMultipleDefinitions = parts[1].contains(",");

        if (hasMultipleDefinitions) {
            List<String> otherBagsRaw = Arrays.asList(parts[1].split(", "));
            parseOtherBag(bag, otherBagsRaw);
        } else if (!parts[1].contains("no other bags")) {
            parseSingleBag(bag, parts[1]);
        }

        return bag;
    }

    private List<Bag> parseOtherBag(Bag bag, List<String> otherBags) {
        return otherBags.stream()
                .map(otherBagStr -> parseSingleBag(bag, otherBagStr))
                .collect(Collectors.toList());
    }

    private Bag parseSingleBag(Bag bag, String bagDefinition) {
        String[] parts = bagDefinition.split(" ");
        int count = Integer.parseInt(parts[0]);
        String bagColourName = parts[1] + " " + parts[2];

        Bag otherBag = new Bag(bagColourName);
        bag.add(otherBag, count);
        return otherBag;
    }
}
