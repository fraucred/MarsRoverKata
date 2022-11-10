package org.example;

import java.util.List;

public record MarsSurface(Integer width, Integer depth, List<Coordinates> obstacles) {
    public boolean detectsObstacle(Coordinates coordinates) {
        return obstacles.stream()
                .anyMatch(coordinates::equals);
    }
}