package Game;

import Game.Piece_Color;

public class Player {

    private String name;
    private Piece_Color pieceColor; //each player choose a color to play with
    private Boolean active = Boolean.FALSE;

    public Player (String name, Piece_Color pieceColor)
    {
        this.name = name;
        this.pieceColor = pieceColor;
    }

    public String getName() {return name;}
    public Piece_Color getColor() {return pieceColor;}
    public Boolean IsActive() {return active;}

    public void setActive(Boolean active) {this.active = active;}
}
