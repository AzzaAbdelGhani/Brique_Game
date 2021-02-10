package Test_Game;

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
        assertEquals(board.getPosFill(0,0), Piece_Color.BLANK);
        board.fillPos(1,2,Piece_Color.BLACK);
        assertEquals(board.getPosFill(1,2), Piece_Color.BLACK);
    }

    @Test
    public void isValidPosition(){
        int size = board.getSize();
        assertFalse(board.isValidPos(0, size));
        assertFalse(board.isValidPos(-1,size-1));
        assertFalse(board.isValidPos(size-1,-1));
        assertFalse(board.isValidPos(size, size));

        assertTrue(board.isValidPos(0,0));
        assertTrue(board.isValidPos(0,size-1));
        assertTrue(board.isValidPos(size-1,0));
        assertTrue(board.isValidPos(size-1,size-1));
    }
}
