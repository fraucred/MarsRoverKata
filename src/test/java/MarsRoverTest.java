import org.example.MarsRover;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    @Test
    void receives_a_character_array_of_commands() {
        MarsRover marsRover = new MarsRover();
        String commands = "FLFFRBLFR";

        marsRover.receives(commands);

        assertEquals(commands, marsRover.getCommands());
    }

    @Test
    void has_initial_starting_point_and_faces_north_direction() {
        MarsRover marsRover = initMarsRover();
        Point marsRoverCoordinates = marsRover.getCoordinates();
        String marsRoverDirection = marsRover.getDirection();

        assertEquals(new Point(0, 0), marsRoverCoordinates);
        assertEquals("N", marsRoverDirection);
    }

    @Test
    void given_forward_command_rover_moves_forward() {
        MarsRover marsRover = initMarsRover();
        String forwardCommand = "F";
        Point expectedMarsRoverCoordinates = new Point(0, 1);

        marsRover.receives(forwardCommand);

        assertEquals(expectedMarsRoverCoordinates, marsRover.getCoordinates());
    }

    @Test
    void given_backward_command_rover_moves_backward() {
        MarsRover marsRover = initMarsRover();
        String backwardCommand = "B";
        Point expectedMarsRoverCoordinates = new Point(0, -1);

        marsRover.receives(backwardCommand);

        assertEquals(expectedMarsRoverCoordinates, marsRover.getCoordinates());
    }

    @Test
    void given_left_command_rover_moves_to_the_left() {
        MarsRover marsRover = initMarsRover();
        String leftCommand = "L";
        String expectedMarsRoverDirection = "W";

        marsRover.receives(leftCommand);

        assertEquals(expectedMarsRoverDirection, marsRover.getDirection());
    }

    @Test
    void given_right_command_rover_moves_to_the_right() {
        MarsRover marsRover = initMarsRover();
        String rightCommand = "R";
        String expectedMarsRoverDirection = "E";

        marsRover.receives(rightCommand);

        assertEquals(expectedMarsRoverDirection, marsRover.getDirection());
    }

    @Test
    void given_right_command_twice_rover_moves_twice_to_the_right() {
        MarsRover marsRover = initMarsRover();
        String rightCommand = "RR";
        String expectedMarsRoverDirection = "S";

        marsRover.receives(rightCommand);

        assertEquals(expectedMarsRoverDirection, marsRover.getDirection());
    }

    private MarsRover initMarsRover() {
        Point coordinates = new Point(0, 0);
        String direction = "N";
        return new MarsRover(coordinates, direction);
    }
}
