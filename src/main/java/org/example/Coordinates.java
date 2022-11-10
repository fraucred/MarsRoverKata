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

    public Coordinates oppositeEast() {
        return new Coordinates(1, this.y);
    }

    public Coordinates oppositeWest(Integer x) {
        return new Coordinates(x, this.y);
    }

    public Coordinates oppositeNorth() {
        return new Coordinates(this.x, 1);
    }

    public Coordinates oppositeSouth(Integer y) {
        return new Coordinates(this.x, y);
    }

    public boolean isPastWest(Integer width) {
        return this.x > width;
    }

    public boolean isPastSouth(Integer depth) {
        return this.y > depth;
    }

    public boolean isPastEast() {
        return this.x == 0;
    }

    public boolean isPastNorth() {
        return this.y == 0;
    }
}
