package Game;

import java.util.Scanner;

public class Game {
    private Board board = new Board();
    private Player P1, P2;
    private Status gStatus;

    public void startGame(Player P1, Player P2){
        this.P1 = P1;
        this.P2 = P2;
        this.board.initializeBoard();
        this.gStatus = Status.ON;

        //Black plays first
        if(P1.getColor() == Piece_Color.BLACK) { P1.setActive(true); }
        else { P2.setActive(true); }
    }

    public Status getStatus() { return this.gStatus; }

    public void setStatus(Status status) { this.gStatus = status; }

    public Player getActivePlayer() { if(P1.IsActive()) { return P1; } else { return P2; } }

    public Player getOtherPlayer() { if(P1.IsActive()) { return P2; } else { return P1; } }

    public Board getBoard(){return this.board;}

    public Status Play(){
        int move_counter = 0;

        while(this.gStatus == Status.ON){
            Move move = new Move();
            move.Move(this.board, getActivePlayer(), getOtherPlayer());
            while(!move.makeMove()) { move.Move(this.board, getActivePlayer(), getOtherPlayer()); }
            this.board.printBoard();
            move_counter++;
            //check victory
            if (move_counter > 28){
                if (P1.checkPath()) { this.gStatus = Status.P1_WINS; }
                if (P2.checkPath()) { this.gStatus = Status.P2_WINS; }
            }
        }
        return this.gStatus;
    }

    public static void main(String[] args) {
        Player P1 = new Player("P1", Piece_Color.BLACK);
        Player P2 = new Player("P2", Piece_Color.WHITE);
        Game game = new Game();
        game.startGame(P1, P2);
        Status stat = game.Play();
        System.out.println(stat.getString());
    }
}
