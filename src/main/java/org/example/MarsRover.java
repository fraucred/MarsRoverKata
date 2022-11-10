package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MarsRover {
    private Coordinates coordinates;
    private Direction direction;
    private final MarsSurface marsSurface;

    public MarsRover(MarsSurface marsSurface, Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.marsSurface = marsSurface;
    }

    public void readCommands(String commandsArray) {
        List<String> commandsList = Arrays.stream(commandsArray.split("")).toList();
        for (String command : commandsList) {   // stream instead of for each
            Coordinates newCoordinates = Coordinates.wrapOnEdge(moveOrTurn(command), marsSurface);
            if (detectObstacle(newCoordinates)) {
                System.out.println("There is an obstacle found at coordinates " + newCoordinates);  // TODO SRP
                break;
            } else {
                this.coordinates = newCoordinates;
            }
        }
    }

    private Coordinates moveOrTurn(String command) {
        if ("L".equals(command)) {  // conditions pas homogenes
            this.direction = this.direction.left();
        } else if ("R".equals(command)) {
            this.direction = this.direction.right();
        } else if ("F".equals(command)) {
            return this.direction.forward(this.coordinates);
        } else {
            return this.direction.backward(this.coordinates);
        }
        return this.coordinates;
    }

    private boolean detectObstacle(Coordinates coordinates) {
        return this.marsSurface.obstacleExists(coordinates);
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "coordinates=" + coordinates +
                ", direction=" + direction +
                ", marsSurface=" + marsSurface +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return Objects.equals(coordinates, marsRover.coordinates) && direction == marsRover.direction && Objects.equals(marsSurface, marsRover.marsSurface);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction, marsSurface);
    }
}
