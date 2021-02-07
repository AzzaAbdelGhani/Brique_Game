package Test_Game;

import Game.Piece_Color;
import org.junit.jupiter.api.Test;
import Game.Player;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void checkNameAndColor() {
        Player p1 = new Player("test", Piece_Color.BLACK);
        assertEquals(p1.getName(),"test");
        assertEquals(p1.getColor(), Piece_Color.BLACK);
    }

    @Test
    public void checkStatusOfPlayer() {
        Player p2 = new Player("test", Piece_Color.BLACK);
        assertFalse(p2.IsActive());

    }
}
