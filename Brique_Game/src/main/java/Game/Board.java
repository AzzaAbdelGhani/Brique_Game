package Game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private static final int size = 15;
    private Position[][] grid = new Position[size][size];

    public void initializeBoard(){ IntStream.range(0,size).forEach(i->IntStream.range(0,size).forEach(j->this.grid[i][j] = new Position(i,j))); }

    public int getSize() { return size; }

    public Position getPos(Coordinates coordinates) { return this.grid[coordinates.getX()][coordinates.getY()]; }

    public boolean isValidPos(Coordinates coordinates) {
        List<Integer> range = IntStream.range(0,size).boxed().collect(Collectors.toList());
        if(range.contains(coordinates.getX()) && range.contains(coordinates.getY())) { return Boolean.TRUE; }
        return Boolean.FALSE;
    }

    public boolean isBorderPos(Coordinates coordinates){
        if(coordinates.getX() == size-1 || coordinates.getY() == size-1) return Boolean.TRUE;
        if(coordinates.getX() == 0 || coordinates.getY() == 0) return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
