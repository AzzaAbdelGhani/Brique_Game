package Test_Game;

import Game.Piece_Color;
import org.junit.jupiter.api.Test;
import Game.Player;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player p = new Player("test", Piece_Color.BLACK);
    @Test
    public void checkNameAndColor() {
        assertEquals(p.getName(),"test");
        assertEquals(p.getColor(), Piece_Color.BLACK);
    }

    @Test
    public void checkStatusOfPlayer() {
        assertFalse(p.IsActive());

    }
}
