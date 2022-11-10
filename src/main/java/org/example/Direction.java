package org.example;

public enum Direction {
    NORTH {
        @Override
        Direction left() {
            return WEST;
        }

        @Override
        Direction right() {
            return EAST;
        }

        @Override
        Coordinates forward(Coordinates coordinates) {
            return coordinates.moveNorth();
        }

        @Override
        Coordinates backward(Coordinates coordinates) {
            return coordinates.moveSouth();
        }
    },
    EAST {
        @Override
        Direction left() {
            return NORTH;
        }

        @Override
        Direction right() {
            return SOUTH;
        }

        @Override
        Coordinates forward(Coordinates coordinates) {
            return coordinates.moveEast();
        }

        @Override
        Coordinates backward(Coordinates coordinates) {
            return coordinates.moveWest();
        }
    },
    SOUTH {
        @Override
        Direction left() {
            return EAST;
        }

        @Override
        Direction right() {
            return WEST;
        }

        @Override
        Coordinates forward(Coordinates coordinates) {
            return NORTH.backward(coordinates);
        }

        @Override
        Coordinates backward(Coordinates coordinates) {
            return NORTH.forward(coordinates);
        }
    },
    WEST {
        @Override
        Direction left() {
            return SOUTH;
        }

        @Override
        Direction right() {
            return NORTH;
        }

        @Override
        Coordinates forward(Coordinates coordinates) {
            return EAST.backward(coordinates);
        }

        @Override
        Coordinates backward(Coordinates coordinates) {
            return EAST.forward(coordinates);
        }
    };

    abstract Direction left();

    abstract Direction right();

    abstract Coordinates forward(Coordinates coordinates);

    abstract Coordinates backward(Coordinates coordinates);
}
