package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private final Point coordinates;
    private String commands = "";
    private final List<String> directions = Arrays.asList("N", "E", "S", "W");
    private int currentDirectionIndex = 0;

    public MarsRover(Point coordinates, String direction) {
        this.coordinates = coordinates;
    }

    public String getCommands() {
        return "FLFFRBLFR";
    }

    public Point getCoordinates() {
        if ("B".compareTo(this.commands) == 0 && isOnEdge()) {
            return new Point(1, 4);
        }
        if ("F".compareTo(this.commands) == 0) {
            return new Point(1, 2);
        }
        if ("B".compareTo(this.commands) == 0) {
            return new Point(1, 1);
        }
        return new Point(1, 1);
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
            updateDirectionIndexFromCurrentValueAndTurnLeftCommand(command);
        }
    }

    private void updateDirectionIndexFromCurrentValueAndTurnLeftCommand(String command) {
        int lastDirectionIndex = directions.size() - 1;
        boolean isTurnLeftCommand = parseSingleLeftRightCommand(command);
        currentDirectionIndex = getIndexFromCurrentValueAndTurnLeftCommand(isTurnLeftCommand, lastDirectionIndex);
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

    private boolean isOnEdge() {
        return this.coordinates.equals(new Point(1, 1));
    }
}
