package org.example;

import java.util.List;

public record MarsSurface(Integer width, Integer depth, List<Coordinates> obstacles) {
    public boolean hasObstacle(Coordinates coordinatesAfterMove) {
        return obstacles.stream()
                .anyMatch(coordinatesAfterMove::equals);
    }
}