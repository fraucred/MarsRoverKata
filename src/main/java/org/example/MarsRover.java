package org.example;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private Coordinates coordinates;
    private Direction direction;
    private final MarsSurface marsSurface;

    public MarsRover(MarsSurface marsSurface, Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
        this.marsSurface = marsSurface;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void readCommands(String commands) {
        List<String> commandsList = Arrays.stream(commands.split("")).toList();
        for (String command : commandsList) {
            moveOrTurn(command);
        }
    }

    private void moveOrTurn(String command) { // noms méthodes trop longues
        if ("L".equals(command)) {
            this.direction = this.direction.turnLeft(); // est-ce que c'est la direction qui tourne ou le rover ?
        } else if ("R".equals(command)) {
            this.direction = this.direction.turnRight();
        } else if ("F".equals(command)) {
            this.coordinates = this.direction.moveForward(this.marsSurface, this.coordinates); //new concept ou déplacer méthode sur autre objet ?
        } else {
            this.coordinates = this.direction.moveBackward(this.marsSurface, this.coordinates);
        }
    }

}
