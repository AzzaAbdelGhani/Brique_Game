package Test_Game;

import Game.Graph;
import Game.Piece_Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {

    @Test
    public void isAddingNodeProperly()
    {
        Graph g1 = new Graph(Piece_Color.BLACK);
        g1.add_node(0,5);
        assertEquals(5, g1.Adjacency_List.get(5).get(0));
    }

    @Test
    public void checkEdgesBetweenNodes()
    {
        Graph g2 = new Graph(Piece_Color.BLACK);
        g2.add_node(0,5);
        g2.add_node(1,5);
        assertTrue(g2.Adjacency_List.get(5).contains(20));
    }

    @Test
    public void checkConnectionBetweenBorders()
    {
        Graph g3 = new Graph(Piece_Color.BLACK);
        g3.add_node(10, 7);
        g3.add_node(8, 7);
        g3.add_node(0, 7);
        g3.add_node(6, 7);
        g3.add_node(14, 7);
        g3.add_node(1, 7);
        g3.add_node(5, 7);
        g3.add_node(2, 7);
        g3.add_node(7, 7);
        g3.add_node(3, 7);
        g3.add_node(12, 7);
        g3.add_node(4, 7);
        g3.add_node(13, 7);
        g3.add_node(9, 7);
        g3.add_node(11, 7);
        assertTrue(g3.areBordersConnected());
    }
}
