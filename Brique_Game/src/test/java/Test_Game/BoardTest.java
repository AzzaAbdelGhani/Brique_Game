package Test_Game;

import Game.Coordinates;
import Game.Piece_Color;
import Game.Pos_Color;
import Game.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void fillBoard(){
        board.initializeBoard();
        assertEquals(board.getPos(new Coordinates(0,0)).getPieceColor(), Piece_Color.BLANK);
        board.getPos(new Coordinates(1,2)).setPieceColor(Piece_Color.BLACK);
        assertEquals(board.getPos(new Coordinates(1,2)).getPieceColor(), Piece_Color.BLACK);
    }

    @Test
    public void isValidPosition(){
        int size = board.getSize();
        assertFalse(board.isValidPos(new Coordinates(0,size)));
        assertFalse(board.isValidPos(new Coordinates(-1,size-1)));
        assertFalse(board.isValidPos(new Coordinates(size-1,-1)));
        assertFalse(board.isValidPos(new Coordinates(size, size)));

        assertTrue(board.isValidPos(new Coordinates(0,0)));
        assertTrue(board.isValidPos(new Coordinates(0,size-1)));
        assertTrue(board.isValidPos(new Coordinates(size-1,0)));
        assertTrue(board.isValidPos(new Coordinates(size-1,size-1)));
    }
}
