package com.squarewave.day4;

import com.squarewave.common.utils.ParserUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PassportDataParser {

    private final ParserUtils parserUtils;

    public PassportDataParser(ParserUtils parserUtils) {
        this.parserUtils = parserUtils;
    }

    public List<Passport> parse(List<String> rawDataLines) {
        return parserUtils.getChunks(rawDataLines).stream()
                .map(chunk -> {
                    String dataLine = String.join(" ", chunk);

                    List<DataPair> passportData = Arrays.stream(dataLine.split(" "))
                            .map(part -> {
                                String[] keyValue = part.split(":");
                                PassportDataType passportDataType = PassportDataType.fromAlias(keyValue[0])
                                        .orElseThrow(IllegalArgumentException::new);

                                return new DataPair(passportDataType, keyValue[1]);
                            })
                            .collect(Collectors.toList());

                    return new Passport(passportData);
                })
                .collect(Collectors.toList());
    }
}
