package Game;

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

        this.board.printBoard();
        System.out.println("Please enter the coordinate values between 0 and " + board.getSize());
    }

    public Status getStatus() { return this.gStatus; }

    public Player getActivePlayer() { if(P1.IsActive()) { return P1; } else { return P2; } }
}
