package org.example;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private Coordinates coordinates;
    private Direction direction;
    private final Land land;

    public MarsRover(Land land, Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.land = land;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public Direction getDirection() {
        return this.direction;
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
        if ("L".compareTo(command) == 0) {
            this.direction = this.direction.turnLeft();
        } else if ("R".compareTo(command) == 0) {
            this.direction = this.direction.turnRight();
        } else {
            boolean isMoveForwardCommand = parseForwardBackwardCommand(command);
            moveToNewCoordinates(isMoveForwardCommand);
        }
    }

    private boolean parseForwardBackwardCommand(String command) {
        return "F".compareTo(command) == 0;
    }

    private void moveToNewCoordinates(boolean isMoveForwardCommand) {
        if (isMoveForwardCommand) {
            this.coordinates = this.direction.moveForward(this.land, this.coordinates);
        } else {
            this.coordinates = this.direction.moveBackward(this.land, this.coordinates);
        }
    }

}
