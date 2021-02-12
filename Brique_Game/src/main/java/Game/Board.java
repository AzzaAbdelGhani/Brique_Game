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

    public Pos_Color getPosColor(int i, int j) { return  this.grid[i][j].getPosColor(); }

    public boolean isValidPos(int i, int j) {
        if (i < 0 || j < 0 || i >= this.size || j >= this.size) { return Boolean.FALSE; }
        return Boolean.TRUE;
    }

    public void fillEscorts(int i, int j){
        Piece_Color current = getPosFill(i,j);
        Pos_Color color = getPosColor(i,j);
        if ( i != size-1 && j != size-1 ) {
            if (current == getPosFill(i+1,j+1) && color == Pos_Color.LIGHT) { fillPos(i,j+1, current); }
            if (current == getPosFill(i+1,j+1) && color == Pos_Color.DARK) { fillPos(i+1,j,current); }
        }
        if ( i != 0 && j != 0 ){
            if (current == getPosFill(i-1,j-1) && color == Pos_Color.LIGHT) { fillPos(i-1,j,current); }
            if (current == getPosFill(i-1,j-1) && color == Pos_Color.DARK){ fillPos(i,j-1,current);}
        }
        if (i == size-1 && color == Pos_Color.DARK) { fillPos(i,j+1,current); }
    }

    public void printBoard(){
        for(int i = size-1; i >=0; i--){
            for(int j = 0; j < size; j++){
                Piece_Color color = getPosFill(i,j);
                System.out.print(color.getString() + "\t");
            }
            System.out.println(" ");
        }
    }

}
