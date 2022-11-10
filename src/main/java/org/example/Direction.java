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
        Coordinates moveForward(MarsSurface marsSurface, Coordinates coordinates) {
            Coordinates coordinatesAfterMove = coordinates.moveNorth(marsSurface.depth());
            return marsSurface.hasObstacle(coordinatesAfterMove) ? coordinates : coordinatesAfterMove;
        }

        @Override
        Coordinates moveBackward(MarsSurface marsSurface, Coordinates coordinates) {
            Coordinates coordinatesAfterMove = coordinates.moveSouth(marsSurface.depth());
            return marsSurface.hasObstacle(coordinatesAfterMove) ? coordinates : coordinatesAfterMove;
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
        Coordinates moveForward(MarsSurface marsSurface, Coordinates coordinates) {
            Coordinates coordinatesAfterMove = coordinates.moveEast(marsSurface.width());
            return marsSurface.hasObstacle(coordinatesAfterMove) ? coordinates : coordinatesAfterMove;
        }

        @Override
        Coordinates moveBackward(MarsSurface marsSurface, Coordinates coordinates) {
            Coordinates coordinatesAfterMove = coordinates.moveWest(marsSurface.width());
            return marsSurface.hasObstacle(coordinatesAfterMove) ? coordinates : coordinatesAfterMove;
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
        Coordinates moveForward(MarsSurface marsSurface, Coordinates coordinates) {
            return NORTH.moveBackward(marsSurface, coordinates);
        }

        @Override
        Coordinates moveBackward(MarsSurface marsSurface, Coordinates coordinates) {
            return NORTH.moveForward(marsSurface, coordinates);
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
        Coordinates moveForward(MarsSurface marsSurface, Coordinates coordinates) {
            return EAST.moveBackward(marsSurface, coordinates);
        }

        @Override
        Coordinates moveBackward(MarsSurface marsSurface, Coordinates coordinates) {
            return EAST.moveForward(marsSurface, coordinates);
        }
    };


    abstract Direction turnLeft();

    abstract Direction turnRight();

    abstract Coordinates moveForward(MarsSurface marsSurface, Coordinates coordinates);

    abstract Coordinates moveBackward(MarsSurface marsSurface, Coordinates coordinates);
}
