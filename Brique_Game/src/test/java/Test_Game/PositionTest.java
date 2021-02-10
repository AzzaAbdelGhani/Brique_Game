package Test_Game;

import Game.Piece_Color;
import Game.Pos_Color;
import Game.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    private Position po = new Position(0,0, Pos_Color.LIGHT);

    @Test
    public void checkRowIdColId(){
        assertEquals(po.getRow_idx(),0);
        assertEquals(po.getCol_idx(), 0);
        assertEquals(po.getPieceColor(), Piece_Color.BLANK);
        assertEquals(po.getPosColor(), Pos_Color.LIGHT);
    }

    @Test
    public void checkPieceColorPosColor(){
        po.setPieceColor(Piece_Color.BLACK);
        assertEquals(po.getPieceColor(), Piece_Color.BLACK);
        po.setPosColor(Pos_Color.DARK);
        assertEquals(po.getPosColor(),Pos_Color.DARK);
    }

}
