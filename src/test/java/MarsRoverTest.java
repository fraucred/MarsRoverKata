import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    @Test
    void has_initial_starting_point_and_faces_north_direction() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        assertEquals(new Coordinates(1, 1), marsRover.getCoordinates());
        assertEquals(Direction.NORTH, marsRover.getDirection());
    }

    @Test
    void given_forward_command_rover_moves_forward() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.moveByCommands("F");

        assertEquals(new Coordinates(1, 2), marsRover.getCoordinates());
    }

    @Test
    void given_backward_command_rover_moves_backward() {
        MarsRover marsRover = initMarsRover(1, 2, Direction.NORTH);

        marsRover.moveByCommands("B");

        assertEquals(new Coordinates(1, 1), marsRover.getCoordinates());
    }

    // TODO parametered tests
//    @ParameterizedTest
//    @CsvSource

    @Test
    void given_left_command_rover_moves_to_the_left() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.moveByCommands("L");

        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    @Test
    void given_right_command_rover_moves_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.moveByCommands("R");

        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    void given_right_command_twice_rover_moves_twice_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.moveByCommands("RR");

        assertEquals(Direction.SOUTH, marsRover.getDirection());
    }

    @Test
    void given_right_command_three_times_rover_moves_three_times_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.moveByCommands("RRR");

        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    @Test
    void given_backward_command_rover_moves_backward_and_wraps_edge() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.moveByCommands("B");

        assertEquals(new Coordinates(1, 10), marsRover.getCoordinates());
    }

    @Test
    void starts_at_1_1_NORTH_and_moves_to_1_1_WEST_facing_obstacles_with_complex_commands() {
        MarsRover marsRover = initMarsRoverWithObstacle(1, 1, Direction.NORTH);

        marsRover.moveByCommands("RFFFFFFFBRFFLFRFFLF");

        assertEquals(new Coordinates(7, 7), marsRover.getCoordinates());
        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    @Test
    void starts_at_1_1_NORTH_and_moves_to_1_3_EAST_with_FBFFR_commands() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.moveByCommands("FBFFR");

        assertEquals(new Coordinates(1, 3), marsRover.getCoordinates());
        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    void starts_at_1_1_NORTH_and_moves_to_9_3_WEST_with_FBFFLFF_commands() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.moveByCommands("FBFFLFF");

        assertEquals(new Coordinates(9, 3), marsRover.getCoordinates());
        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    private MarsRover initMarsRover(int x, int y, Direction direction) {
        Land marsLand = new Land(10, 10, Collections.emptyList());
        return new MarsRover(marsLand, new Coordinates(x, y), direction);
    }

    private MarsRover initMarsRoverWithObstacle(int x, int y, Direction direction) {
        Obstacle firstObstacle = new Obstacle(new Coordinates(8, 1));
        Obstacle secondObstacle = new Obstacle(new Coordinates(7, 9));
        List<Obstacle> obstacles = Arrays.asList(firstObstacle, secondObstacle);
        Land marsLand = new Land(10, 10, obstacles);
        return new MarsRover(marsLand, new Coordinates(x, y), direction);
    }
}
