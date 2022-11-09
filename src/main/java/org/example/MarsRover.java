package org.example;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private Coordinates coordinates;
    private final DirectionIndex directionIndex;

    public MarsRover(Coordinates coordinates, DirectionIndex directionIndex) {
        this.coordinates = coordinates;
        this.directionIndex = directionIndex;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public Direction getDirection() {
        return directionIndex.getDirection();
    }

    public void moveByCommands(String commands) {
        readAndApplyCommands(commands);
    }

    private void readAndApplyCommands(String commands) {
        List<String> commandsList = Arrays.stream(commands.split("")).toList();
        for (String command : commandsList) {
            changeDirectionOrCoordinates(command);
        }
    }

    private void changeDirectionOrCoordinates(String command) {
        if ("L".compareTo(command) == 0 || "R".compareTo(command) == 0) {
            boolean isTurnLeftCommand = parseLeftRightCommand(command);
            changeDirection(isTurnLeftCommand);
        } else {
            boolean isMoveForwardCommand = parseForwardBackwardCommand(command);
            moveToNewCoordinates(isMoveForwardCommand);
        }
    }

    private void changeDirection(boolean isTurnLeftCommand) {
        directionIndex.changeDirection(isTurnLeftCommand);
    }

    private boolean parseLeftRightCommand(String command) {
        return "L".compareTo(command) == 0;
    }

    private boolean parseForwardBackwardCommand(String command) {
        return "F".compareTo(command) == 0;
    }

    private void moveToNewCoordinates(boolean isMoveForwardCommand) {
        if (directionIndex.isFacingNorth()) {
            if (isMoveForwardCommand) {
                this.coordinates = this.coordinates.incrementY();   // value object + primitive obsession
            } else {
                this.coordinates = this.coordinates.decrementY();
            }
        } else if (directionIndex.isFacingEast()) {
            if (isMoveForwardCommand) {
                this.coordinates = this.coordinates.incrementX();
            } else {
                this.coordinates = this.coordinates.decrementX();
            }
        } else if (directionIndex.isFacingSouth()) {
            if (isMoveForwardCommand) {
                this.coordinates = this.coordinates.decrementY();
            } else {
                this.coordinates = this.coordinates.incrementY();
            }
        } else if (directionIndex.isFacingWest()) {
            if (isMoveForwardCommand) {
                this.coordinates = this.coordinates.decrementX();
            } else {
                this.coordinates = this.coordinates.incrementX();
            }
        }
    }

}
