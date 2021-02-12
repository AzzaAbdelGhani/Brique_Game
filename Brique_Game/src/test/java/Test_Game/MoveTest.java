package Test_Game;

import Game.Piece_Color;
import Game.Move;
import Game.Player;
import Game.Board;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    Player P1 = new Player("p1", Piece_Color.BLACK);
    Player P2 = new Player("p2", Piece_Color.WHITE);
    Board board = new Board();
    Move move = new Move();

    @Test
    public void initiateMove(){
        board.initializeBoard();
        InputStream backup = System.in;
        System.setIn(new ByteArrayInputStream("2 4".getBytes()));
        move.Move(board, P1, P2);
        assertEquals(move.getX()+1, 4);
        assertEquals(move.getY()+1, 2);

    }

    @Test
    public void areEscortsFilled(){
        board.initializeBoard();
        InputStream backup = System.in;
        System.setIn(new ByteArrayInputStream("2 4".getBytes()));
        move.Move(board, P1, P2);

        //Tests for Light Interior Positions
        move.fillBoardandUpdateGraph(5,5, Piece_Color.BLACK);
        move.fillBoardandUpdateGraph(4,4,Piece_Color.BLACK);
        move.fillBoardandUpdateGraph(6,6,Piece_Color.BLACK);
        move.fillEscorts(5,5);
        assertEquals(board.getPosFill(5,5), board.getPosFill(4, 5));
        assertEquals(board.getPosFill(5,5), board.getPosFill(5, 6));

        //Test for Dark Interior Positions
        move.fillBoardandUpdateGraph(1,2,Piece_Color.WHITE);
        move.fillBoardandUpdateGraph(2,3,Piece_Color.WHITE);
        move.fillBoardandUpdateGraph(3,4,Piece_Color.WHITE);
        move.fillEscorts(2,3);
        assertEquals(board.getPosFill(2,3), board.getPosFill(3,3));
        assertEquals(board.getPosFill(2,3),board.getPosFill(2,2));
    }

    @Test
    public void makingaValidMove(){
        board.initializeBoard();
        InputStream backup = System.in;
        System.setIn(new ByteArrayInputStream("0 4".getBytes()));
        move.Move(board, P1, P2);
        assertFalse(move.makeMove());

        System.setIn(new ByteArrayInputStream("6 16".getBytes()));
        move.Move(board, P1, P2);
        assertFalse(move.makeMove());

        System.setIn(new ByteArrayInputStream("5 4".getBytes()));
        move.Move(board, P1, P2);
        assertTrue(move.makeMove());
        System.setIn(backup);
    }

}
