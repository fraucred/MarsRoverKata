package org.example;

public record Coordinates(Integer x, Integer y) {

    public Coordinates moveEast() {
        return new Coordinates(this.x + 1, this.y);
    }

    public Coordinates moveWest() {
        return new Coordinates(this.x - 1, this.y);
    }

    public Coordinates moveNorth() {
        return new Coordinates(this.x, this.y + 1);
    }

    public Coordinates moveSouth() {
        return new Coordinates(this.x, this.y - 1);
    }

    public static Coordinates wrapOnEdge(Coordinates coordinates, MarsSurface marsSurface) {
        if (coordinates.isPastWest(marsSurface.width())) {
            return coordinates.oppositeEast();
        } else if (coordinates.isPastSouth(marsSurface.depth())) {
            return coordinates.oppositeNorth();
        } else if (coordinates.isPastEast()) {
            return coordinates.oppositeWest(marsSurface.width());
        } else if (coordinates.isPastNorth()) {
            return coordinates.oppositeSouth(marsSurface.depth());
        }
        return coordinates;
    }

    private Coordinates oppositeEast() {
        return new Coordinates(1, this.y);
    }

    private Coordinates oppositeWest(Integer x) {
        return new Coordinates(x, this.y);
    }

    private Coordinates oppositeNorth() {
        return new Coordinates(this.x, 1);
    }

    private Coordinates oppositeSouth(Integer y) {
        return new Coordinates(this.x, y);
    }

    private boolean isPastWest(Integer width) {
        return this.x > width;
    }

    private boolean isPastSouth(Integer depth) {
        return this.y > depth;
    }

    private boolean isPastEast() {
        return this.x == 0;
    }

    private boolean isPastNorth() {
        return this.y == 0;
    }
}
