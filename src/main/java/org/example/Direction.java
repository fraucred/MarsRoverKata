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
        Coordinates moveForward(Land land, Coordinates coordinates) {
            return coordinates.incrementY(land.depth());
        }

        @Override
        Coordinates moveBackward(Land land, Coordinates coordinates) {
            return coordinates.decrementY(land.depth());
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
        Coordinates moveForward(Land land, Coordinates coordinates) {
            return coordinates.incrementX(land.width());
        }

        @Override
        Coordinates moveBackward(Land land, Coordinates coordinates) {
            return coordinates.decrementX(land.width());
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
        Coordinates moveForward(Land land, Coordinates coordinates) {
            return NORTH.moveBackward(land, coordinates);
        }

        @Override
        Coordinates moveBackward(Land land, Coordinates coordinates) {
            return NORTH.moveForward(land, coordinates);
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
        Coordinates moveForward(Land land, Coordinates coordinates) {
            return EAST.moveBackward(land, coordinates);
        }

        @Override
        Coordinates moveBackward(Land land, Coordinates coordinates) {
            return EAST.moveForward(land, coordinates);
        }
    };


    abstract Direction turnLeft();

    abstract Direction turnRight();

    abstract Coordinates moveForward(Land land, Coordinates coordinates);

    abstract Coordinates moveBackward(Land land, Coordinates coordinates);
}
