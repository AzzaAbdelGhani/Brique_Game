package Game;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public final List<List<Integer>> Adjacency_List;
    private Piece_Color pieceColor;
    private Board board;

    public Graph(Piece_Color pieceColor)
    {
        this.pieceColor = pieceColor;
        Adjacency_List = new ArrayList<List<Integer>>();
        for (int i = 0; i < 225; i++)
        {
            ArrayList<Integer> new_list = new ArrayList<>();
            Adjacency_List.add(i,new_list);
        }
    }

    public void updateGraph(Board board, Coordinates coordinates){
        this.board = board;
        add_node(coordinates);
    }

    private int get_Index(Coordinates coordinates) {return coordinates.getX()*15 + coordinates.getY() ;}

    public void setEdge(int src , int des)
    {
        if (Adjacency_List.get(des).isEmpty()) { Adjacency_List.get(des).add(des); }
        Adjacency_List.get(des).add(src);
        Adjacency_List.get(src).add(des);
    }

    private boolean isNeighbourFilled(Coordinates coordinates){
        if(board.isValidPos(coordinates)){
            if(board.getPos(coordinates).getPieceColor() == pieceColor) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void check_neighbours(Coordinates coordinates)
    {
        ArrayList<Coordinates> neighbours = new ArrayList<>();
        neighbours.add(coordinates.getUp());
        neighbours.add(coordinates.getDown());
        neighbours.add(coordinates.getLeft());
        neighbours.add(coordinates.getRight());

        for(Coordinates n:neighbours) {
            if(isNeighbourFilled(n)) setEdge(get_Index(coordinates),get_Index(n));
        }
    }

    public void add_node(Coordinates coordinates)
    {
        int idx = get_Index(coordinates);
        Adjacency_List.get(idx).add(idx);
        check_neighbours(coordinates);
    }

    private ArrayList<List<Integer>> getBorders()
    {
        ArrayList<List<Integer>> borders = new ArrayList<List<Integer>>();
        ArrayList<Integer> b1 = new ArrayList<Integer>();
        ArrayList<Integer> b2 = new ArrayList<Integer>();
        if (this.pieceColor == Piece_Color.BLACK){
            for (int i = 0, j = 210; i < 15 && j < 225; i++, j++) {
                b1.add(i);
                b2.add(j);
            }
        }
        if (this.pieceColor == Piece_Color.WHITE){
            for (int i = 0, j = 14; i < 211 && j < 225; i+=15, j+=15) {
                b1.add(i);
                b2.add(j);
            }

        }
        borders.add(0,b1);
        borders.add(1,b2);
        return borders;
    }

    private void DFS(Integer e, ArrayList<Integer> visited)
    {
        visited.add(e);
        for (Integer i : Adjacency_List.get(e))
        {
            if (!visited.contains(i))
                DFS(i,visited);
        }
    }

    public boolean areBordersConnected()
    {
        ArrayList<List<Integer>> borders = getBorders();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        for(Integer e : borders.get(0))
        {
            if (Adjacency_List.get(e).contains(e))
            {
                DFS(e,visited);
                if(!visited.isEmpty()){
                    for (Integer v : visited)
                    {
                        if (borders.get(1).contains(v)) return true;
                    }
                }
            }
        }
        return false;
    }

}
