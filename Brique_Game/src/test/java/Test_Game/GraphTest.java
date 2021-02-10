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
}
