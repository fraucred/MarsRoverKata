import org.example.MarsRover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    @Test
    void receives_a_character_array_of_commands() {
        MarsRover marsRover = new MarsRover();
        String commands = "FLFFRBLFR";

        marsRover.receives(commands);

        assertEquals(commands, marsRover.getCommands());
    }
}
