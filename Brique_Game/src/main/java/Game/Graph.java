package Game;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final Piece_Color pieceColor;
    public final List<List<Integer>> Adjacency_List;

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

    public int get_Index(int row, int col) {    return row*15 + col ;   }

    public void add_node(int row, int col)
    {
        int idx = get_Index(row, col);
        Adjacency_List.get(idx).add(idx);
    }

    public void printGraph()
    {
        System.out.println ("Adjacency List for the graph \n");
        for (List<Integer> l : Adjacency_List)
        {
            if(!l.isEmpty()) {
                for (int i = 0; i < l.size(); i++) {
                    System.out.print("->" + l.get(i));
                }
                System.out.print("\n");
            }
        }
    }

    public static void main(String...arg)
    {
        Graph adjacencyList = new Graph(Piece_Color.BLACK);
        adjacencyList.add_node(10, 7);
        adjacencyList.add_node(8, 7);
        adjacencyList.add_node(0, 7);
        adjacencyList.add_node(6, 7);
        adjacencyList.add_node(14, 7);
        adjacencyList.add_node(1, 7);
        adjacencyList.add_node(5, 7);
        adjacencyList.add_node(2, 7);
        adjacencyList.add_node(7, 7);
        adjacencyList.add_node(3, 7);
        adjacencyList.add_node(12, 7);
        adjacencyList.add_node(4, 7);
        adjacencyList.add_node(13, 7);
        adjacencyList.add_node(9, 7);
        adjacencyList.add_node(11, 7);

        adjacencyList.printGraph();
    }
}
