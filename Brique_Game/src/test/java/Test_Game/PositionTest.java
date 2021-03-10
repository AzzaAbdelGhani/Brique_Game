package Test_Game;

import Game.Coordinates;
import Game.Piece_Color;
import Game.Pos_Color;
import Game.Position;
import org.junit.jupiter.api.Test;

import java.awt.image.ColorConvertOp;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    private Position po = new Position(0,0);
    private Position po2 = new Position(0,1);

    @Test
    public void checkRowIdColId(){
        assertEquals(po.getCoordinates().getX(),0);
        assertEquals(po.getCoordinates().getY(), 0);
        assertEquals(po.getPieceColor(), Piece_Color.BLANK);
        assertEquals(po.getPosColor(), Pos_Color.LIGHT);
        assertEquals(po2.getPosColor(), Pos_Color.DARK);
    }

    @Test
    public void checkPieceColorPosColor(){
        po.setPieceColor(Piece_Color.BLACK);
        assertEquals(po.getPieceColor(), Piece_Color.BLACK);
    }

}
