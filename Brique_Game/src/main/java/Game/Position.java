package Game;

public class Position {
    private int row_idx;
    private int col_idx;
    private Piece_Color pColor = Piece_Color.BLANK;
    private Pos_Color posColor;

    public Position(int row_idx, int col_idx, Pos_Color posColor){
        this.row_idx = row_idx;
        this.col_idx = col_idx;
        this.posColor = posColor;
    }

    public int getRow_idx(){
        return this.row_idx;
    }

    public int getCol_idx(){ return this.col_idx; }

    public Pos_Color getPosColor(){
        return this.posColor;
    }

    public Piece_Color getPieceColor(){ return this.pColor; }

    public void setPosColor(Pos_Color posColor) {
        this.posColor = posColor;
    }

    public void setPieceColor(Piece_Color pColor) {
        this.pColor = pColor;
    }

}
