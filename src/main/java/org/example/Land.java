package org.example;

import java.util.List;

public record Land(Integer width, Integer depth, List<Obstacle> obstacles) {
}