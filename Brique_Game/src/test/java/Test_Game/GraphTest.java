package Test_Game;

import Game.Coordinates;
import Game.Graph;
import Game.Piece_Color;
import Game.Board;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {
    
    private final Graph g = new Graph(Piece_Color.BLACK);
    private Board board = new Board();


    @Test
    public void isAddingNodeProperly()
    {
        board.initializeBoard();
        Coordinates co = new Coordinates(0,5);
        board.getPos(co).setPieceColor(Piece_Color.BLACK);
        g.updateGraph(board, co);
        assertEquals(5, g.Adjacency_List.get(5).get(0));
    }

    @Test
    public void checkEdgesBetweenNodes()
    {
        board.initializeBoard();
        Coordinates co = new Coordinates(0,5);
        board.getPos(co).setPieceColor(Piece_Color.BLACK);
        g.updateGraph(board, co);
        Coordinates co1 = new Coordinates(1,5);
        g.updateGraph(board, co1);
        assertTrue(g.Adjacency_List.get(5).contains(20));
    }

    @Test
    public void checkConnectionBetweenBorders()
    {
        board.initializeBoard();
        ArrayList<Coordinates> connection = new ArrayList<>();
        IntStream.range(0,15).forEach(i->connection.add(new Coordinates(i,7)));
        for(Coordinates c:connection){
            board.getPos(c).setPieceColor(Piece_Color.BLACK);
            g.updateGraph(board,c);
        }
        assertTrue(g.areBordersConnected());
    }
}
