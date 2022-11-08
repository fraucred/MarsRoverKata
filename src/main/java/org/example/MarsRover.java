package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private final Point coordinates;
    private String commands = "";
    private final List<String> directions = Arrays.asList("N", "E", "S", "W");
    private int currentDirectionIndex;

    public MarsRover(Point coordinates, String direction) {
        this.coordinates = coordinates;
        this.currentDirectionIndex = directions.indexOf(direction);
    }

    public String getCommands() {
        return "FLFFRBLFR";
    }

    public Point getCoordinates() {
        return this.coordinates;
    }

    public String getDirection() {
        return directions.get(currentDirectionIndex);
    }

    public void receives(String commands) {
        this.commands = commands;
        moveRoverByCommands();
    }

    private void moveRoverByCommands() {
        List<String> commands = Arrays.stream(this.commands.split("")).toList();
        for (String command : commands) {
            updateCoordinatesOrDirection(command);
        }
    }

    private void updateCoordinatesOrDirection(String command) {
        if ("L".compareTo(command) == 0 || "R".compareTo(command) == 0) {
            int lastDirectionIndex = directions.size() - 1;
            boolean isTurnLeftCommand = parseSingleLeftRightCommand(command);
            currentDirectionIndex = getIndexFromCurrentValueAndTurnLeftCommand(isTurnLeftCommand, lastDirectionIndex);
        } else {
            boolean isMoveForwardCommand = parseSingleForwardBackwardCommand(command);
            updateCoordinates(isMoveForwardCommand);
        }
    }

    private int getIndexFromCurrentValueAndTurnLeftCommand(boolean isTurnLeftCommand, int lastDirectionIndex) {
        if (isTurnLeftCommand && currentDirectionIndex == 0) {
            return lastDirectionIndex;
        }
        if (!isTurnLeftCommand && currentDirectionIndex == lastDirectionIndex) {
            return 0;
        }
        if (isTurnLeftCommand) {
            return currentDirectionIndex - 1;
        } else {
            return currentDirectionIndex + 1;
        }
    }

    private boolean parseSingleLeftRightCommand(String command) {
        return "L".compareTo(command) == 0;
    }

    private boolean parseSingleForwardBackwardCommand(String command) {
        return "F".compareTo(command) == 0;
    }

    private void updateCoordinates(boolean isMoveForwardCommand) {
        int x = (int) this.coordinates.getX();
        int y = (int) this.coordinates.getY();
        switch (currentDirectionIndex) {
            case 0:
                if (isMoveForwardCommand) {
                    this.coordinates.move(x, y + 1);
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
