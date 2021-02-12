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

    public void fillEscorts_interior(int i, int j){
        Piece_Color current = getPosFill(i,j);
        Piece_Color diag_up = getPosFill(i+1,j+1);
        Piece_Color diag_down = getPosFill(i-1,j-1);
        if (getPosColor(i,j) == Pos_Color.LIGHT){
            if (current == diag_up){ fillPos(i,j+1, current); }
            if (current == diag_down){ fillPos(i-1,j,current); }
        }
        else {
            if (current == diag_up){ fillPos(i+1,j,current); }
            if (current == diag_down){ fillPos(i,j-1,current);}
        }
    }

    public void fillEscorts_edges(int i, int j){
        Pos_Color posColor = getPosColor(i,j);
        Piece_Color current = getPosFill(i,j);
        if (i == 0 || j == 0){
            Piece_Color diag_up = getPosFill(i+1,j+1);
            if (current == diag_up){
                if(posColor == Pos_Color.DARK) { fillPos(i+1,j,current); }
                else { fillPos(i,j+1,current); }
            }
        }
        if (i == size-1 || j == size-1){
            Piece_Color diag_down = getPosFill(i-1,j-1);
            if (current == diag_down){
                if(posColor == Pos_Color.DARK) { fillPos(i,j-1,current); }
                else { fillPos(i-1,j,current); }
            }
        }
        if (i == size-1 && posColor == Pos_Color.DARK) { fillPos(i,j+1,current); }
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
