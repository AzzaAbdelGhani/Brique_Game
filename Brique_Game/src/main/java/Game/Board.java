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

    public void reset(){ initializeBoard(); }

    public int getSize() { return size; }

    public void fillPos(int i, int j, Piece_Color pColor){
        this.grid[i][j].setPieceColor(pColor);
    }

    public Piece_Color getPosFill(int i, int j){
        return this.grid[i][j].getPieceColor();
    }

    public boolean isValidPos(int i, int j) {
        if (i < 0 || j < 0 || i >= this.size || j >= this.size) { return Boolean.FALSE; }
        return Boolean.TRUE;
    }

    public void printBoard(){
        for(int i = size-1; i >=0; i--){
            for(int j = 0; j < size; j++){
                Piece_Color color = this.grid[i][j].getPieceColor();
                System.out.print(color.getString() + "\t");
            }
            System.out.println(" ");
        }
    }

}
