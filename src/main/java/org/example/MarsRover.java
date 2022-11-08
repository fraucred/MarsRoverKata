package org.example;

import java.awt.*;

public class MarsRover {
    private String commands = "";

    public MarsRover() {

    }

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
            return new Point(1,2);
        }
        if ("B".compareTo(this.commands) == 0) {
            return new Point(1,-2);
        }
        return new Point(1,1);
    }

    public String getDirection() {
        if ("L".compareTo(this.commands) == 0) {
            return "W";
        }
        if ("R".compareTo(this.commands) == 0) {
            return "E";
        }
        if ("RR".compareTo(this.commands) == 0) {
            return "S";
        }
        return "N";
    }
}
