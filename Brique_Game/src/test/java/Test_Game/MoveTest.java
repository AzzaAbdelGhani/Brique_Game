package Test_Game;

import Game.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.ColumnOrderDependent;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    Player P1 = new Player("p1", Piece_Color.BLACK);
    Player P2 = new Player("p2", Piece_Color.WHITE);
    Board board = new Board();
    Coordinates coordinates = new Coordinates(0,0);
    Move move = new Move(board,P1,P2,coordinates);

    @Test
    public void makeaMove(){
        board.initializeBoard();
        P1.setActive(true);
        move.makeMove();
        assertFalse(P1.IsActive());
        assertTrue(P2.IsActive());
        assertEquals(board.getPos(coordinates).getPieceColor(),Piece_Color.BLACK);
        Coordinates coordinates1 = new Coordinates(-1,2);
        Move invalid_move = new Move(board, P2, P1, coordinates1);
        assertFalse(invalid_move.makeMove());
    }

    @Test
    public void escortFilling(){
        board.initializeBoard();
        move.makeMove(); // Player 1 made a move filling the position 0,0
        Coordinates co1 = new Coordinates(1,1);
        P1.setActive(true); //set Player 1 active again
        P2.setActive(false);
        Move move2 = new Move(board, P1, P2, co1);
        move2.makeMove(); //Player 1 again makes a move filling the diagonal up position of 1,1
        //Now the escort has to be filled. The positions filled are light colors
        assertEquals(board.getPos(co1.getLeft()).getPieceColor(), P1.getColor());

        board.initializeBoard();
        Coordinates co2 = new Coordinates(3,4);
        Move move3 = new Move(board, P2, P1, co2);
        move3.makeMove(); // P2 fills the position 3,4 which is dark
        P2.setActive(true); //set P2 again active
        P1.setActive(false);
        Coordinates co3 = new Coordinates(2,3);
        Move move4 = new Move(board, P2, P1, co3);
        move4.makeMove(); //P2 again makes a move filling 2,3 which is diagonal down for 3,4
        assertEquals(board.getPos(co3.getRight()).getPieceColor(), P2.getColor());
    }

}
