package org.example;

import java.util.Arrays;
import java.util.List;

public class DirectionIndex {
    private final List<Direction> directions = Arrays.stream(Direction.values()).toList();
    private int index;

    public DirectionIndex(Direction direction) {
        this.index = direction.ordinal();
    }

    public Direction getDirection() {
        return directions.get(this.index);
    }

    public void changeDirection(boolean isTurnLeftCommand) {
        if (isTurnLeftCommand) {
            turnLeft();
        } else {
            turnRight();
        }
    }

    public boolean isFacingNorth() {
        return this.index == 0;
    }

    public boolean isFacingEast() {
        return this.index == 1;
    }

    public boolean isFacingSouth() {
        return this.index == 2;
    }

    public boolean isFacingWest() {
        return this.index == directions.size() - 1;
    }

    private void turnRight() {
        if (this.index == directions.size() - 1) {
            faceNorth();
        } else {
            this.index++;
        }
    }

    private void turnLeft() {
        if (this.index == 0) {
            faceWest();
        } else {
            this.index--;
        }
    }

    private void faceWest() {
        this.index = directions.size() - 1;
    }

    private void faceNorth() {
        this.index = 0;
    }
}
