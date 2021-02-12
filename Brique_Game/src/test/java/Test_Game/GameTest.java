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
        public void activePlayers(){
            P1.setActive(true);
            P2.setActive(false);
            game.startGame(P1,P2);
            assertEquals(P1, game.getActivePlayer());
            assertEquals(P2, game.getOtherPlayer());
        }

        @Test
        public void playingtheGame(){
            String moves = "1 1 3 4 2 2 6 7 3 3 1 5 4 4 1 6 5 5 1 8 6 6 1 10 7 7 1 11 7 8 14 15 7 9 2 5 7 10 10 5 8 11 13 8 9 12 6 1 9 13 6 2 9 13 4 9 10 14 2 9 10 15 12 15";
            InputStream backup = System.in;
            System.setIn(new ByteArrayInputStream(moves.getBytes()));
            game.startGame(P1,P2);
            //assertEquals(Status.P1_WINS,game.Play());
        }
}
