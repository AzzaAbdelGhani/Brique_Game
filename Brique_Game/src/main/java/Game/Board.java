package Game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private static final int size = 15;
    private Position[][] grid = new Position[size][size];

    public void initializeBoard(){ IntStream.range(0,size).forEach(i->IntStream.range(0,size).forEach(j->this.grid[i][j] = new Position(i,j))); }

    public int getSize() { return size; }

    public Position getPos(int r, int c) {return this.grid[r][c];}

    public Piece_Color getPosFill(int i, int j){ return this.grid[i][j].getPieceColor(); }

    public Pos_Color getPosColor(int i, int j) { return  this.grid[i][j].getPosColor(); }

    public void fillPos(int i, int j, Piece_Color pColor){ this.grid[i][j].setPieceColor(pColor); }

    public boolean isValidPos(int i, int j) {
        List<Integer> range = IntStream.rangeClosed(0,size).boxed().collect(Collectors.toList());
        if(range.contains(i) && range.contains(j)) { return Boolean.TRUE; }
        return Boolean.FALSE;
    }
}
