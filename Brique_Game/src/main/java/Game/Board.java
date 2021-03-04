package Game;

public class Board {
    private static final int size = 15;
    private Position[][] grid = new Position[size][size];

    public void initializeBoard(){
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                this.grid[i][j] = new Position(i,j,Pos_Color.LIGHT);
                if((i+j)%2 != 0){ this.grid[i][j].setPosColor(Pos_Color.DARK); }
            }
        }
    }

    //public void reset(){ initializeBoard(); }

    public int getSize() { return size; }

    public Position getPos(int r, int c) {return this.grid[r][c];}

    public void fillPos(int i, int j, Piece_Color pColor){
        this.grid[i][j].setPieceColor(pColor);
    }

    public Piece_Color getPosFill(int i, int j){
        return this.grid[i][j].getPieceColor();
    }

    public Pos_Color getPosColor(int i, int j) { return  this.grid[i][j].getPosColor(); }

    public boolean isValidPos(int i, int j) {
        if (i < 0 || j < 0 || i >= this.size || j >= this.size) { return Boolean.FALSE; }
        return Boolean.TRUE;
    }
}
