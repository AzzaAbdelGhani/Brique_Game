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

    @Test
    public void fillEscorts_interior(){
        board.initializeBoard();
        //Tests for Light Positions
        board.fillPos(5,5,Piece_Color.BLACK);
        board.fillPos(4,4,Piece_Color.BLACK);
        board.fillPos(6,6,Piece_Color.BLACK);
        board.fillEscorts(5,5);
        assertEquals(board.getPosFill(5,5), board.getPosFill(4, 5));
        assertEquals(board.getPosFill(5,5), board.getPosFill(5, 6));

        //Test for dark positions
        board.fillPos(1,2,Piece_Color.WHITE);
        board.fillPos(2,3,Piece_Color.WHITE);
        board.fillPos(3,4,Piece_Color.WHITE);
        board.fillEscorts(2,3);
        assertEquals(board.getPosFill(2,3), board.getPosFill(3,3));
        assertEquals(board.getPosFill(2,3),board.getPosFill(2,2));

    }

    @Test
    public void fillEscorts_edges(){
        board.initializeBoard();
        //Bottom Edge Light Color Positions
        board.fillPos(0,0,Piece_Color.WHITE);
        board.fillPos(1,1,Piece_Color.WHITE);
        board.fillEscorts(0,0);
        assertEquals(board.getPosFill(0,0),board.getPosFill(0,1));

        //Bottom Edge Dark Color Positions
        board.fillPos(0,3,Piece_Color.BLACK);
        board.fillPos(1,4,Piece_Color.BLACK);
        board.fillEscorts(0,3);
        assertEquals(board.getPosFill(0,3),board.getPosFill(1,3));

        //Top Edge Light Color Positions
        board.fillPos(14,2,Piece_Color.BLACK);
        board.fillPos(13,1,Piece_Color.BLACK);
        board.fillEscorts(14,2);
        assertEquals(board.getPosFill(14,2),board.getPosFill(13,2));

        //Top Edge Dark Color Positions
        board.fillPos(14,6,Piece_Color.WHITE);
        board.fillPos(13,5, Piece_Color.WHITE);
        board.fillEscorts(14,7);
        assertEquals(board.getPosFill(14,7),board.getPosFill(14,6));
        assertEquals(board.getPosFill(14,7),board.getPosFill(14,8));
    }

}
