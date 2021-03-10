package Game;

public class Position {
    private Coordinates coordinates;
    private Pos_Color posColor;
    private Piece_Color pColor = Piece_Color.BLANK;

    public Position(int row_idx, int col_idx){
        coordinates = new Coordinates(row_idx, col_idx);
        if ((row_idx + col_idx) % 2 == 0) this.posColor = Pos_Color.LIGHT;
        else this.posColor = Pos_Color.DARK;
    }

    public Coordinates getCoordinates() { return  this.coordinates;}

    public Pos_Color getPosColor(){
        return this.posColor;
    }

    public Piece_Color getPieceColor(){ return this.pColor; }

    public void setPieceColor(Piece_Color pColor) {
        this.pColor = pColor;
    }

}
