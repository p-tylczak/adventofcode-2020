package com.squarewave.day2;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2 {

    public long day2Part1(String fileName) throws IOException {
        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicyValidator validator = new PasswordPolicyValidator();

        return Files.readAllLines(Paths.get(fileName)).stream()
                .map(passwordPolicyParser::parse)
                .filter(validator::isPasswordValid)
                .count();
    }

    public long day2Part2(String fileName) throws IOException {
        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        TobogganPasswordPolicyValidator validator = new TobogganPasswordPolicyValidator();

        return Files.readAllLines(Paths.get(fileName)).stream()
                .map(passwordPolicyParser::parse)
                .filter(validator::isPasswordValid)
                .count();
    }

    private static class PasswordPolicyParser {
        private PasswordPolicy parse(String input) {
            String[] parts = input.split(":");
            String[] rawPolicy = parts[0].split(" ");
            String[] rawRanges = rawPolicy[0].split("-");

            String password = parts[1].trim();

            String of = rawPolicy[1];
            int from = Integer.parseInt(rawRanges[0]);
            int to = Integer.parseInt(rawRanges[1]);

            return new PasswordPolicy(from, to, of, password);
        }
    }

    private static class PasswordPolicy {
        private int min;
        private int max;
        private String character;
        private String password;

        private PasswordPolicy(int min, int max, String character, String password) {
            this.min = min;
            this.max = max;
            this.character = character;
            this.password = password;
        }
    }

    private static class PasswordPolicyValidator {
        public boolean isPasswordValid(PasswordPolicy passwordPolicy) {
            int count = StringUtils.countMatches(passwordPolicy.password, passwordPolicy.character);
            return count >= passwordPolicy.min && count <= passwordPolicy.max;
        }
    }

    private static class TobogganPasswordPolicyValidator {
        public boolean isPasswordValid(PasswordPolicy passwordPolicy) {
            String pass = passwordPolicy.password;

            char char1 = pass.charAt(passwordPolicy.min - 1);
            char char2 = pass.charAt(passwordPolicy.max - 1);

            char testAgainst = passwordPolicy.character.toCharArray()[0];

            return (char1 == testAgainst || char2 == testAgainst) && (char1 != char2);
        }
    }
}
