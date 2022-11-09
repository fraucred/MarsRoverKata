package org.example;

public record Coordinates(Integer x, Integer y) {

    public Coordinates incrementX() {
        return new Coordinates(this.x + 1, this.y);
    }

    public Coordinates decrementX() {
        return new Coordinates(this.x - 1, this.y);
    }

    public Coordinates incrementY() {
        return new Coordinates(this.x, this.y + 1);
    }

    public Coordinates decrementY() {
        return new Coordinates(this.x, this.y - 1);
    }
}
