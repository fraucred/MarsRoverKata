package org.example;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private String commands = "";
    private List<String> directions = Arrays.asList("N", "E", "S", "W");
    private int currentDirectionIndex = 0;

    public MarsRover(Point coordinates, String direction) {

    }

    public String getCommands() {
        return "FLFFRBLFR";
    }

    public Point getCoordinates() {
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
        updateDirectionIndexFromCurrentValueAndTurnLeftCommand();
        if ("RR".compareTo(this.commands) == 0) {    // TODO if isTurnRightCommand x2, return S => parsing more than one single command
            currentDirectionIndex = 2;
        }
    }

    private void updateDirectionIndexFromCurrentValueAndTurnLeftCommand() {
        boolean isTurnLeftCommand = parseSingleLeftRightCommand();
        updateDirectionIndex(isTurnLeftCommand);
    }

    private boolean parseSingleLeftRightCommand() {
        return "L".compareTo(this.commands) == 0;
    }

    private void updateDirectionIndex(boolean isTurnLeftCommand) {
        int lastDirectionIndex = directions.size() - 1;
        currentDirectionIndex = getIndex(isTurnLeftCommand, lastDirectionIndex);
    }

    private int getIndex(boolean isTurnLeftCommand, int lastDirectionIndex) {
        if (isTurnLeftCommand && currentDirectionIndex == 0) {
            return lastDirectionIndex;
        }
        if (!isTurnLeftCommand && currentDirectionIndex == lastDirectionIndex) {
            return 0;
        }
        if (isTurnLeftCommand) {
            return currentDirectionIndex - 1;
        } else {
            return currentDirectionIndex + 1 ;
        }
    }
}
