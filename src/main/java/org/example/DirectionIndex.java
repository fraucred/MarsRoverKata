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
        if (isTurnLeftCommand && isFirst()) {
            overlapFromFirst();
        } else if (!isTurnLeftCommand && isLast()) {
            overlapFromLast();
        } else if (isTurnLeftCommand) {
            decrement();
        } else {
            increment();
        }
    }

    private void increment() {
        this.index++;
    }

    private void decrement() {
        this.index--;
    }

    private boolean isFirst() {
        return this.index == 0;
    }

    private boolean isLast() {
        return this.index == directions.size() - 1;
    }

    private void overlapFromFirst() {
        this.index = directions.size() - 1;
    }

    private void overlapFromLast() {
        this.index = 0;
    }
}
