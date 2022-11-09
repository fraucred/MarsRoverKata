package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private final Point coordinates;
    private final DirectionIndex directionIndex;

    public MarsRover(Point coordinates, DirectionIndex directionIndex) {
        this.coordinates = coordinates;
        this.directionIndex = directionIndex;
    }

    public String getCommands() {
        return "FLFFRBLFR";
    }

    public Point getCoordinates() {
        return this.coordinates;
    }

    public String getDirection() {
        return directionIndex.getDirection();
    }

    public void moveByCommands(String commands) {
        readAndApplyCommands(commands);
    }

    private void readAndApplyCommands(String commands) {
        List<String> commandsList = Arrays.stream(commands.split("")).toList();
        for (String command : commandsList) {
            updateDirectionOrCoordinates(command);
        }
    }

    private void updateDirectionOrCoordinates(String command) {
        if ("L".compareTo(command) == 0 || "R".compareTo(command) == 0) {
            boolean isTurnLeftCommand = parseLeftRightCommand(command);
            updateDirection(isTurnLeftCommand);
        } else {
            boolean isMoveForwardCommand = parseForwardBackwardCommand(command);
            updateCoordinates(isMoveForwardCommand);
        }
    }

    private void updateDirection(boolean isTurnLeftCommand) {
        directionIndex.updateDirection(isTurnLeftCommand);
    }

    private boolean parseLeftRightCommand(String command) {
        return "L".compareTo(command) == 0;
    }

    private boolean parseForwardBackwardCommand(String command) {
        return "F".compareTo(command) == 0;
    }

    private void updateCoordinates(boolean isMoveForwardCommand) {
        int x = (int) this.coordinates.getX();
        int y = (int) this.coordinates.getY();
        switch (directionIndex.getIndex()) {
            case 0:
                if (isMoveForwardCommand) {
                    this.coordinates.move(x, y + 1);
//                    this.coordinates = new Point(x, y + 1);
//                    this.coordinates.decrementY();
                } else {
                    this.coordinates.move(x, y - 1);
                }
                break;
            case 1:
                if (isMoveForwardCommand) {
                    this.coordinates.move(x + 1, y);
                } else {
                    this.coordinates.move(x - 1, y);
                }
                break;
            case 2:
                if (isMoveForwardCommand) {
                    this.coordinates.move(x, y - 1);
                } else {
                    this.coordinates.move(x, y + 1);
                }
                break;
            case 3:
                if (isMoveForwardCommand) {
                    this.coordinates.move(x - 1, y);
                } else {
                    this.coordinates.move(x + 1, y);
                }
                break;
        }
    }

}
