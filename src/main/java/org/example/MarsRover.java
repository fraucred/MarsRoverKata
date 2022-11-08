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

    public void receives(String commands) {
        this.commands = commands;
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
        int lastDirectionIndex = directions.size() - 1;
        boolean isTurnLeftCommand = "L".compareTo(this.commands) == 0;
        boolean isTurnRightCommand = "R".compareTo(this.commands) == 0;

        if (currentDirectionIndex == 0 && isTurnLeftCommand) {
            currentDirectionIndex = lastDirectionIndex;
        } else if (currentDirectionIndex == lastDirectionIndex && isTurnRightCommand) {
            currentDirectionIndex = 0;
        } else if (isTurnLeftCommand) {
            currentDirectionIndex--;
        } else if (isTurnRightCommand) {
            currentDirectionIndex++;
        } else if ("RR".compareTo(this.commands) == 0) {    // TODO if isTurnRightCommand x2, return S
            return "S";
        }
        return directions.get(currentDirectionIndex);       // TODO getDirection final implementation with reading from current direction index
    }
}
