package com.squarewave.day7;

import com.squarewave.common.utils.ParserUtils;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public class Day7 {

    private final ParserUtils parserUtils = new ParserUtils();
    private final BagPolicyParser bagPolicyParser = new BagPolicyParser();

    public Long getCombinationCount(String fileName) {
        List<Bag> bags = bagPolicyParser.parse(parserUtils.readLines(fileName));

        Set<Bag> possibleCombinations = new HashSet<>();

        Set<Bag> shinyGoldBagSet = new HashSet<>();
        shinyGoldBagSet.add(new Bag("shiny gold"));

        checkPossibilities(bags, shinyGoldBagSet, possibleCombinations);

        return (long) possibleCombinations.size();
    }

    public BigInteger getBagCount(String fileName) {
        List<Bag> bags = bagPolicyParser.parse(parserUtils.readLines(fileName));
        return countContent(bags, new Bag("shiny gold"));
    }

    private void checkPossibilities(List<Bag> allBags, Set<Bag> bagsToCheck, Set<Bag> possibleCombinations) {
        Set<Bag> toCheck = new HashSet<>();

        for (Bag bag : allBags) {
            for (Bag bagToCheck : bagsToCheck) {
                if (bag.bagContent().stream().anyMatch(b -> b.getColour().equals(bagToCheck.getColour()))) {
                    toCheck.add(bag);
                    possibleCombinations.add(bag);
                }
            }
        }

        if (toCheck.isEmpty()) {
            return;
        }

        checkPossibilities(allBags, toCheck, possibleCombinations);
    }

    private BigInteger countContent(List<Bag> allBags, Bag bagToCheck) {
        Bag toCheck = allBags.stream()
                .filter(bag -> bagToCheck.getColour().equals(bag.getColour()))
                .findFirst()
                .orElseThrow();

        return toCheck.getCountByBag().entrySet().stream()
                .map(kv -> {
                    BigInteger count = valueOf(kv.getValue());
                    BigInteger bigInteger = countContent(allBags, kv.getKey());
                    return count.add(bigInteger.multiply(count));
                })
                .reduce(BigInteger::add)
                .orElse(ZERO);
    }
}
