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
        Point coordinates = new Point(0, 0);
        String direction = "N";
        MarsRover marsRover = new MarsRover(coordinates, direction);

        Point marsRoverCoordinates = marsRover.getCoordinates();
        String marsRoverDirection = marsRover.getDirection();

        assertEquals(coordinates, marsRoverCoordinates);
        assertEquals(direction, marsRoverDirection);
    }

    @Test
    void given_forward_command_rover_moves_forward() {
        Point coordinates = new Point(0, 0);
        String direction = "N";
        MarsRover marsRover = new MarsRover(coordinates, direction);
        String forwardCommand = "F";
        Point expectedMarsRoverCoordinates = new Point(0, 1);

        marsRover.receives(forwardCommand);

        assertEquals(expectedMarsRoverCoordinates, marsRover.getCoordinates());
    }

    @Test
    void given_backward_command_rover_moves_backward() {
        Point coordinates = new Point(0, 0);
        String direction = "N";
        MarsRover marsRover = new MarsRover(coordinates, direction);
        String backwardCommand = "B";
        Point expectedMarsRoverCoordinates = new Point(0, -1);

        marsRover.receives(backwardCommand);

        assertEquals(expectedMarsRoverCoordinates, marsRover.getCoordinates());
    }
}
