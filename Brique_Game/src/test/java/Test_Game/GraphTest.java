package Test_Game;

import Game.Graph;
import Game.Piece_Color;
import Game.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {
    
    private final Graph g = new Graph(Piece_Color.BLACK);
    private Board board = new Board();


    @Test
    public void isAddingNodeProperly()
    {
        board.initializeBoard();
        board.fillPos(0, 5, Piece_Color.BLACK);
        g.updateBoard(board, 0,5);
        assertEquals(5, g.Adjacency_List.get(5).get(0));
    }

    @Test
    public void checkEdgesBetweenNodes()
    {
        board.initializeBoard();
        board.fillPos(0, 5, Piece_Color.BLACK);
        g.updateBoard(board, 0,5);
        board.fillPos(1,5, Piece_Color.BLACK);
        g.updateBoard(board, 1, 5);
        assertTrue(g.Adjacency_List.get(5).contains(20));
    }

    @Test
    public void checkConnectionBetweenBorders()
    {
        board.initializeBoard();
        board.fillPos(10, 7, Piece_Color.BLACK);
        g.updateBoard(board, 10, 7);
        board.fillPos(8, 7, Piece_Color.BLACK);
        g.updateBoard(board, 8, 7);
        board.fillPos(0, 7, Piece_Color.BLACK);
        g.updateBoard(board, 0, 7);
        board.fillPos(1, 7, Piece_Color.BLACK);
        g.updateBoard(board, 1, 7);
        board.fillPos(6, 7, Piece_Color.BLACK);
        g.updateBoard(board, 6, 7);
        board.fillPos(14, 7, Piece_Color.BLACK);
        g.updateBoard(board, 14, 7);
        board.fillPos(5, 7, Piece_Color.BLACK);
        g.updateBoard(board, 5, 7);
        board.fillPos(2, 7, Piece_Color.BLACK);
        g.updateBoard(board, 2, 7);
        board.fillPos(7, 7, Piece_Color.BLACK);
        g.updateBoard(board, 7, 7);
        board.fillPos(3, 7, Piece_Color.BLACK);
        g.updateBoard(board, 3, 7);
        board.fillPos(12, 7, Piece_Color.BLACK);
        g.updateBoard(board, 12, 7);
        board.fillPos(4, 7, Piece_Color.BLACK);
        g.updateBoard(board, 4, 7);
        board.fillPos(13, 7, Piece_Color.BLACK);
        g.updateBoard(board, 13, 7);
        board.fillPos(9, 7, Piece_Color.BLACK);
        g.updateBoard(board, 9, 7);
        board.fillPos(11, 7, Piece_Color.BLACK);
        g.updateBoard(board, 11, 7);
        assertTrue(g.areBordersConnected());
    }
}
