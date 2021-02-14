package Game;

import Game.Piece_Color;

public class Player {

    private String name;
    private Piece_Color pieceColor; //each player choose a color to play with
    private Boolean active = Boolean.FALSE;
    private Graph graph; // each player has a graph represents his movements

    public Player (String name, Piece_Color pieceColor)
    {
        this.name = name;
        this.pieceColor = pieceColor;
        graph = new Graph(pieceColor);
    }

    public String getName() {return name;}
    public Piece_Color getColor() {return pieceColor;}
    public Boolean IsActive() {return active;}
    public Graph getGraph() { return graph; }
    public void updateGraph(Board board, int x, int y) { this.graph.updateBoard(board, x, y); }
    public boolean checkPath() { return this.graph.areBordersConnected(); }
    public void setName(String name) {this.name = name;}
    public void setPieceColor(Piece_Color pieceColor){this.pieceColor = pieceColor;}
    public void setActive(Boolean active) {this.active = active;}
    public void setGraph(Graph graph){this.graph = graph;}
}
