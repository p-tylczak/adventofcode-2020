package com.squarewave.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParserUtils {

    public static final String NEW_LINE = System.getProperty("line.separator");

    public List<List<String>> getChunks(List<String> lines) {
        List<List<String>> result = new ArrayList<>();
        List<String> chunks = new ArrayList<>();

        for (String line : lines) {
            if (StringUtils.isNotBlank(line.trim())) {
                chunks.add(line.trim());
            } else {
                result.add(chunks);
                chunks = new ArrayList<>();
            }
        }

        String lastLine = lines.get(lines.size() - 1);
        if (StringUtils.isNotBlank(lastLine)) {
            result.add(chunks);
        }

        return result;
    }

    public List<String> readLines(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException(String.format("Unable to open file: %s", fileName));
    }

    public String readFileContent(String fileName) {
        try {
            return Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException(String.format("Unable to open file: %s", fileName));
    }

}
