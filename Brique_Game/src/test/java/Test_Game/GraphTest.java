package Test_Game;

import Game.Graph;
import Game.Piece_Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void isAddingNodeProperly()
    {
        Graph g = new Graph(Piece_Color.BLACK);
        g.add_node(0,5);
        assertEquals(5, g.Adjacency_List.get(5).get(0));
    }
}
