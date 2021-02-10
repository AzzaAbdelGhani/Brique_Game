package Test_Game;

import Game.Piece_Color;
import org.junit.jupiter.api.Test;
import Game.Player;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private final Player p = new Player("test", Piece_Color.BLACK);
    @Test
    public void checkNameAndColorAndActivity() {
        assertEquals(p.getName(),"test");
        assertEquals(p.getColor(), Piece_Color.BLACK);
        assertFalse(p.IsActive());
    }

    @Test
    public void checkStatusOfPlayer() {
        p.setActive(Boolean.TRUE);
        assertTrue(p.IsActive());

    }
}
