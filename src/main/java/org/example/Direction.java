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
        Coordinates forward(Coordinates coordinates, MarsSurface marsSurface) {
            return SOUTH.isPast(coordinates.moveNorth(), marsSurface);
        }

        @Override
        Coordinates backward(Coordinates coordinates, MarsSurface marsSurface) {
            return isPast(coordinates.moveSouth(), marsSurface);
        }

        @Override
        Coordinates isPast(Coordinates coordinates, MarsSurface marsSurface) {
            return coordinates.isPastNorth() ? coordinates.oppositeSouth(marsSurface.depth()) : coordinates;
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
        Coordinates forward(Coordinates coordinates, MarsSurface marsSurface) {
            return WEST.isPast(coordinates.moveEast(), marsSurface);
        }

        @Override
        Coordinates backward(Coordinates coordinates, MarsSurface marsSurface) {
            return isPast(coordinates.moveWest(), marsSurface);
        }

        @Override
        Coordinates isPast(Coordinates coordinates, MarsSurface marsSurface) {
            return coordinates.isPastEast() ? coordinates.oppositeWest(marsSurface.width()) : coordinates;
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
        Coordinates forward(Coordinates coordinates, MarsSurface marsSurface) {
            return NORTH.backward(coordinates, marsSurface);
        }

        @Override
        Coordinates backward(Coordinates coordinates, MarsSurface marsSurface) {
            return NORTH.forward(coordinates, marsSurface);
        }

        @Override
        Coordinates isPast(Coordinates coordinates, MarsSurface marsSurface) {
            return coordinates.isPastSouth(marsSurface.depth()) ? coordinates.oppositeNorth() : coordinates;
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
        Coordinates forward(Coordinates coordinates, MarsSurface marsSurface) {
            return EAST.backward(coordinates, marsSurface);
        }

        @Override
        Coordinates backward(Coordinates coordinates, MarsSurface marsSurface) {
            return EAST.forward(coordinates, marsSurface);
        }

        @Override
        Coordinates isPast(Coordinates coordinates, MarsSurface marsSurface) {
            return coordinates.isPastWest(marsSurface.width()) ? coordinates.oppositeEast() : coordinates;
        }

    };

    abstract Direction left();

    abstract Direction right();

    abstract Coordinates forward(Coordinates coordinates, MarsSurface marsSurface);

    abstract Coordinates backward(Coordinates coordinates, MarsSurface marsSurface);

    abstract Coordinates isPast(Coordinates coordinates, MarsSurface marsSurface);
}
