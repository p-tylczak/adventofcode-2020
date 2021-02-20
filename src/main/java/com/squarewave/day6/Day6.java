package com.squarewave.day6;

import com.squarewave.common.utils.ParserUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {

    private final ParserUtils parserUtils = new ParserUtils();

    public BigInteger getCountForAllGroups(String fileName) {
        List<List<String>> groups = parserUtils.getChunks(parserUtils.readLines(fileName));

        List<BigInteger> countsToAdd = new ArrayList<>();

        for (List<String> group : groups) {
            char[] characters = String.join("", group).toCharArray();

            Set<Character> characterSet = new HashSet<>();
            for (char character : characters) {
                characterSet.add(character);
            }

            countsToAdd.add(BigInteger.valueOf(characterSet.size()));
        }

        return countsToAdd.stream()
                .reduce(BigInteger::add)
                .orElseThrow();
    }

    public BigInteger getCountForAllGroupsPart2(String fileName) {
        List<List<String>> groups = parserUtils.getChunks(parserUtils.readLines(fileName));

        List<BigInteger> countsToAdd = new ArrayList<>();

        for (List<String> group : groups) {
            char[] characters = String.join("", group).toCharArray();

            Set<Character> characterSet = new HashSet<>();
            for (char character : characters) {
                characterSet.add(character);
            }

            for (String personAnswers : group) {
                Set<Character> characterSetForPerson = new HashSet<>();

                char[] charactersForPerson = personAnswers.toCharArray();
                for (char character : charactersForPerson) {
                    characterSetForPerson.add(character);
                }

                characterSet.retainAll(characterSetForPerson);
            }

            countsToAdd.add(BigInteger.valueOf(characterSet.size()));
        }

        return countsToAdd.stream()
                .reduce(BigInteger::add)
                .orElseThrow();
    }

}
