package org.example;

import java.util.Arrays;
import java.util.List;

public class DirectionIndex {
    private final List<String> directions = Arrays.asList("N", "E", "S", "W");
    private int index;

    public DirectionIndex(String direction) {
        this.index = directions.indexOf(direction);
    }

    public String getDirection() {
        return directions.get(this.index);
    }

    public int getIndex() {
        return index;
    }

    public void updateDirection(boolean isTurnLeftCommand) {
        if (isTurnLeftCommand && isFacingNorth()) {
            faceWest();
        } else if (!isTurnLeftCommand && isFacingWest()) {
            faceNorth();
        } else if (isTurnLeftCommand) {
            turnLeft();
        } else {
            turnRight();
        }
    }

    private void turnRight() {
        this.index++;
    }

    private void turnLeft() {
        this.index--;
    }

    private boolean isFacingNorth() {
        return this.index == 0;
    }

    private boolean isFacingWest() {
        return this.index == directions.size() - 1;
    }

    private void faceWest() {
        this.index = directions.size() - 1;
    }

    private void faceNorth() {
        this.index = 0;
    }
}
