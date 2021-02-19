package com.squarewave.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day3 {

    private final PatternMetadataParser patternMetadataParser;
    private final CheapTobogganNavigator tobogganNavigator;
    private final CollisionDetector collisionDetector;
    private final DestinationChecker destinationChecker;
    private final CoordinateRewriter coordinateRewriter;

    public Day3(PatternMetadataParser patternMetadataParser,
                CheapTobogganNavigator tobogganNavigator,
                CollisionDetector collisionDetector,
                DestinationChecker destinationChecker,
                CoordinateRewriter coordinateRewriter) {
        this.patternMetadataParser = patternMetadataParser;
        this.tobogganNavigator = tobogganNavigator;
        this.collisionDetector = collisionDetector;
        this.destinationChecker = destinationChecker;
        this.coordinateRewriter = coordinateRewriter;
    }

    public long part1(String fileName, MoveDefinition moveDefinition) throws IOException {
        PatternMetadata patternMetadata = patternMetadataParser.parse(Files.readAllLines(Paths.get(fileName)));

        int numberOfTreeCollisions = 0;

        Coordinates currentCoordinates = new Coordinates(1, 1);

        do {
            currentCoordinates = coordinateRewriter.rewrite(
                    tobogganNavigator.move(currentCoordinates, moveDefinition),
                    patternMetadata);

            if (collisionDetector.hasCollidedWithTree(currentCoordinates, patternMetadata)) {
                numberOfTreeCollisions++;
            }
        } while (!destinationChecker.hasArrived(currentCoordinates, patternMetadata));

        return numberOfTreeCollisions;
    }
}
