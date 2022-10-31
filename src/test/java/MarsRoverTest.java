import org.example.MarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverTest {

    @Test
    void receives_a_character_array_of_commands() {
        MarsRover marsRover = new MarsRover();
        String commands = "FLFFRBLFR";

        marsRover.receives(commands);

        Assertions.assertEquals(commands, marsRover.getCommands());
    }
}
