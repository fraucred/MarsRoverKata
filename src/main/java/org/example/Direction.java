package org.example;

public enum Direction {
    NORTH {
        @Override
        Direction turnLeft() {
            return WEST;
        }

        @Override
        Direction turnRight() {
            return EAST;
        }

        @Override
        Coordinates moveForward(Coordinates coordinates) {
            return coordinates.incrementY();
        }

        @Override
        Coordinates moveBackward(Coordinates coordinates) {
            return coordinates.decrementY();
        }
    },
    EAST {
        @Override
        Direction turnLeft() {
            return NORTH;
        }

        @Override
        Direction turnRight() {
            return SOUTH;
        }

        @Override
        Coordinates moveForward(Coordinates coordinates) {
            return coordinates.incrementX();
        }

        @Override
        Coordinates moveBackward(Coordinates coordinates) {
            return coordinates.decrementX();
        }
    },
    SOUTH {
        @Override
        Direction turnLeft() {
            return EAST;
        }

        @Override
        Direction turnRight() {
            return WEST;
        }

        @Override
        Coordinates moveForward(Coordinates coordinates) {
            return NORTH.moveBackward(coordinates);
        }

        @Override
        Coordinates moveBackward(Coordinates coordinates) {
            return NORTH.moveForward(coordinates);
        }
    },
    WEST {
        @Override
        Direction turnLeft() {
            return SOUTH;
        }

        @Override
        Direction turnRight() {
            return NORTH;
        }

        @Override
        Coordinates moveForward(Coordinates coordinates) {
            return EAST.moveBackward(coordinates);
        }

        @Override
        Coordinates moveBackward(Coordinates coordinates) {
            return EAST.moveForward(coordinates);
        }
    };


    abstract Direction turnLeft();

    abstract Direction turnRight();

    abstract Coordinates moveForward(Coordinates coordinates);

    abstract Coordinates moveBackward(Coordinates coordinates);
}
