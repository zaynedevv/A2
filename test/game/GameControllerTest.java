package game;


import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class GameControllerTest {


    @Test
    public void constructorThrowsWhenParametersAreNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new GameController(null, null, null));
    }

    public void isOutOfBounds() {

    }




}
