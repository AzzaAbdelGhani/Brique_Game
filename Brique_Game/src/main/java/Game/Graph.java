package Game;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public final List<List<Integer>> Adjacency_List;
    private final Piece_Color pieceColor;
    private Board board = new Board();

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

    public void updateBoard(Board board, int row, int col){
        this.board = board;
        add_node(row, col);
    }

    private int get_Index(int row, int col) {return row*15 + col ;}

    public void setEdge(int src , int des)
    {
        if (Adjacency_List.get(des).isEmpty()) { Adjacency_List.get(des).add(des); }
        Adjacency_List.get(des).add(src);
        Adjacency_List.get(src).add(des);
    }

    private void check_neighbours(int row, int col)
    {
        if(this.board.isValidPos(row-1, col))
        {
            if ( this.pieceColor == this.board.getPosFill(row-1,col))
                setEdge(get_Index(row,col), get_Index(row-1,col));
        }
        if(this.board.isValidPos(row+1, col))
        {
            if ( this.pieceColor == this.board.getPosFill(row+1,col))
                setEdge(get_Index(row,col), get_Index(row+1,col));
        }
        if(this.board.isValidPos(row, col-1))
        {
            if ( this.pieceColor == this.board.getPosFill(row,col-1))
                setEdge(get_Index(row,col), get_Index(row,col-1));
        }
        if(this.board.isValidPos(row, col+1))
        {
            if ( this.pieceColor == this.board.getPosFill(row,col+1))
                setEdge(get_Index(row,col), get_Index(row,col+1));
        }
    }

    public void add_node(int row, int col)
    {
        int idx = get_Index(row, col);
        Adjacency_List.get(idx).add(idx);
        check_neighbours(row, col);
    }

    private ArrayList<List<Integer>> getBorders()
    {
        ArrayList<List<Integer>> borders = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; i++)
        {
            ArrayList<Integer> new_list = new ArrayList<>();
            borders.add(i,new_list);
        }
        if (this.pieceColor == Piece_Color.BLACK)
        {
            ArrayList<Integer> up = new ArrayList<Integer>();
            ArrayList<Integer> down = new ArrayList<Integer>();
            for (int i = 0, j = 210; i < 15 && j < 225; i++, j++) {
                up.add(i);
                down.add(j);
            }
            borders.add(0,up);
            borders.add(1,down);
        }
        else if (this.pieceColor == Piece_Color.WHITE)
        {
            ArrayList<Integer> right = new ArrayList<Integer>();
            ArrayList<Integer> left = new ArrayList<Integer>();
            for (int i = 0, j = 14; i < 211 && j < 225; i+=15, j+=15) {
                left.add(i);
                right.add(j);
            }
            borders.add(0,left);
            borders.add(1,right);
        }

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
        printGraph();
        return false;
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
        Graph graph = new Graph(Piece_Color.BLACK);
        Board board = new Board();
        board.initializeBoard();
        board.fillPos(1, 1, Piece_Color.BLACK);
        board.fillEscorts(1, 1);
        graph.updateBoard(board, 1, 1);
        graph.printGraph();
        board.fillPos(2, 2, Piece_Color.BLACK);
        board.fillEscorts(2, 2);
        graph.updateBoard(board, 2,2 );

        graph.printGraph();

    }
}
