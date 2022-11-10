import org.example.Coordinates;
import org.example.Direction;
import org.example.MarsRover;
import org.example.MarsSurface;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

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

        marsRover.readCommands("F");

        assertEquals(new Coordinates(1, 2), marsRover.getCoordinates());
    }

    @Test
    void given_backward_command_rover_moves_backward() {
        MarsRover marsRover = initMarsRover(1, 2, Direction.NORTH);

        marsRover.readCommands("B");

        assertEquals(new Coordinates(1, 1), marsRover.getCoordinates());
    }

    // TODO parametered tests
//    @ParameterizedTest
//    @CsvSource

    @Test
    void given_left_command_rover_moves_to_the_left() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.readCommands("L");

        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    @Test
    void given_right_command_rover_moves_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.readCommands("R");

        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    void given_right_command_twice_rover_moves_twice_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.readCommands("RR");

        assertEquals(Direction.SOUTH, marsRover.getDirection());
    }

    @Test
    void given_right_command_three_times_rover_moves_three_times_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.readCommands("RRR");

        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    @Test
    void given_backward_command_rover_moves_backward_and_wraps_edge() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.readCommands("B");

        assertEquals(new Coordinates(1, 10), marsRover.getCoordinates());
    }

    @Test
    void starts_at_1_1_NORTH_and_moves_to_1_1_EAST_facing_obstacles_with_complex_commands() {
        MarsRover marsRover = initMarsRoverWithObstacles(1, 1, Direction.NORTH);

        marsRover.readCommands("RFFFFFFFBRFFLFRFFLF");

        assertEquals(new Coordinates(7, 7), marsRover.getCoordinates());
        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    void starts_at_1_1_NORTH_and_moves_to_1_3_EAST_with_FBFFR_commands() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.readCommands("FBFFR");

        assertEquals(new Coordinates(1, 3), marsRover.getCoordinates());
        assertEquals(Direction.EAST, marsRover.getDirection());
    }

    @Test
    void starts_at_1_1_NORTH_and_moves_to_9_3_WEST_with_FBFFLFF_commands() {
        MarsRover marsRover = initMarsRover(1, 1, Direction.NORTH);

        marsRover.readCommands("FBFFLFF");

        assertEquals(new Coordinates(9, 3), marsRover.getCoordinates());
        assertEquals(Direction.WEST, marsRover.getDirection());
    }

    private MarsRover initMarsRover(int x, int y, Direction direction) {
        MarsSurface marsLand = new MarsSurface(10, 10, Collections.emptyList());
        return new MarsRover(marsLand, new Coordinates(x, y), direction);
    }

    private MarsRover initMarsRoverWithObstacles(int x, int y, Direction direction) {
        Coordinates firstObstacle = new Coordinates(8, 1);
        Coordinates secondObstacle = new Coordinates(7, 9);
        MarsSurface marsSurface = new MarsSurface(10, 10, Arrays.asList(firstObstacle, secondObstacle));
        return new MarsRover(marsSurface, new Coordinates(x, y), direction);
    }
}
