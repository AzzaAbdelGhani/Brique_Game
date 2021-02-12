package Test_Game;

import Game.Piece_Color;
import Game.Status;
import Game.Game;
import Game.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
public class GameTest {
        private Player P1 = new Player("P1", Piece_Color.BLACK);
        private Player P2 = new Player("P2", Piece_Color.WHITE);
        private Game game = new Game();

        @Test
        public void startingtheGame(){
            game.startGame(P1,P2);
            assertEquals(game.getStatus(),Status.ON);
            assertEquals(game.getActivePlayer().getColor(),Piece_Color.BLACK);
        }

        @Test
        public void fillBoard(){
            game.startGame(P1,P2);
            InputStream backup = System.in;
            System.setIn(new ByteArrayInputStream("-1 2 3 4".getBytes()));
            assertEquals(P1.getColor(),game.scanCoordinatesandFill(P1.getName(),P1.getColor()));
            System.setIn(new ByteArrayInputStream("3 4 5 6".getBytes()));
            assertEquals(P2.getColor(),game.scanCoordinatesandFill(P2.getName(),P2.getColor()));
            System.setIn(backup);
        }
}
