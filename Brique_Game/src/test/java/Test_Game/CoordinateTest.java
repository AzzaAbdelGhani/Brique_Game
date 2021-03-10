package Test_Game;

import Game.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {
    private Coordinates coordinates = new Coordinates(0,0);

    @Test
    public void getCoordinates(){
        assertEquals(0,coordinates.getX());
        assertEquals(0,coordinates.getY());
    }
    public void getNeighbours(){
        Coordinates coordinates1 = new Coordinates(5,5);
        assertEquals(6, coordinates1.getUp().getY());
        assertEquals(5, coordinates1.getUp().getX());
        assertEquals(6, coordinates1.getRight().getX());
        assertEquals(5, coordinates1.getRight().getY());
    }
}
