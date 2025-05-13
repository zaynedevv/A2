package game;

import game.achievements.AchievementManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {


    @Test
    void constructorThrowsWhenParametersAreNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new GameController(null, null, null));
    }




}
