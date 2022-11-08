import org.example.MarsRover;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    @Test
    void receives_a_character_array_of_commands() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        marsRover.receives("FLFFRBLFR");

        assertEquals("FLFFRBLFR", marsRover.getCommands());
    }

    @Test
    void has_initial_starting_point_and_faces_north_direction() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        assertEquals(new Point(1, 1), marsRover.getCoordinates());
        assertEquals("N", marsRover.getDirection());
    }

    @Test
    void given_forward_command_rover_moves_forward() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        marsRover.receives("F");

        assertEquals(new Point(1, 2), marsRover.getCoordinates());
    }

    @Test
    void given_backward_command_rover_moves_backward() {
        MarsRover marsRover = initMarsRover(1, 2, "N");

        marsRover.receives("B");

        assertEquals(new Point(1, 1), marsRover.getCoordinates());
    }

    @Test
    void given_left_command_rover_moves_to_the_left() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        marsRover.receives("L");

        assertEquals("W", marsRover.getDirection());
    }

    @Test
    void given_right_command_rover_moves_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        marsRover.receives("R");

        assertEquals("E", marsRover.getDirection());
    }

    @Test
    void given_right_command_twice_rover_moves_twice_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        marsRover.receives("RR");

        assertEquals("S", marsRover.getDirection());
    }
    @Test
    void given_right_command_three_times_rover_moves_three_times_to_the_right() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        marsRover.receives("RRR");

        assertEquals("W", marsRover.getDirection());
    }

    @Test
    void given_backward_command_rover_moves_backward_and_wraps_edge() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        marsRover.receives("B");

        assertEquals(new Point(1, 4), marsRover.getCoordinates());
    }

    @Test
    void starts_at_1_1_north_and_moves_to_1_3_E_with_FBFFR_commands() {
        MarsRover marsRover = initMarsRover(1, 1, "N");

        marsRover.receives("FBFFR");

        assertEquals(new Point(1, 3), marsRover.getCoordinates());
        assertEquals("E", marsRover.getDirection());
    }

    private MarsRover initMarsRover(int x, int y, String direction) {
        return new MarsRover(new Point(x, y), direction);
    }
}
