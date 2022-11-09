package org.example;

public record Coordinates(Integer x, Integer y) {

    public Coordinates incrementX(Integer width) {
        if (this.x + 1 > width) {
            return new Coordinates(1, this.y);
        }
        return new Coordinates(this.x + 1, this.y);
    }

    public Coordinates decrementX(Integer width) {
        if (this.x - 1 == 0) {
            return new Coordinates(width, this.y);
        }
        return new Coordinates(this.x - 1, this.y);
    }

    public Coordinates incrementY(Integer depth) {
        if (this.y + 1 > depth) {
            return new Coordinates(this.x, 1);
        }
        return new Coordinates(this.x, this.y + 1);
    }

    public Coordinates decrementY(Integer depth) {
        if (this.y - 1 == 0) {
            return new Coordinates(this.x, depth);
        }
        return new Coordinates(this.x, this.y - 1);
    }
}
