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

    public Player getActivePlayer() { if(P1.IsActive()) { return P1; } else { return P2; } }

    public Player getOtherPlayer() { if(P1.IsActive()) { return P2; } else { return P1; } }

    public Piece_Color scanCoordinatesandFill(String playerName, Piece_Color color) {
        System.out.println(playerName + "'s turn");
        System.out.print("Enter coordinates i: (1-" + board.getSize() + "), j: (1-" + board.getSize() + "):");
        Scanner sc = new Scanner(System.in);
        int x, y;
        y = sc.nextInt() - 1;
        x = sc.nextInt() - 1;
        while (!this.board.isValidPos(x,y) || this.board.getPosFill(x,y) != Piece_Color.BLANK) {
            System.out.println("Invalid Coordinates, please enter again");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        }
        this.board.fillPos(x,y,color);
        return this.board.getPosFill(x,y);
    }

    public Status Play(){
        Player currentPlayer, otherPlayer;
        int move_counter = 0;
        //Simulating a simple game
        while(this.gStatus == Status.ON){
            currentPlayer = getActivePlayer();
            otherPlayer = getOtherPlayer();
            scanCoordinatesandFill(currentPlayer.getName(), currentPlayer.getColor());
            currentPlayer.setActive(false);
            otherPlayer.setActive(true);
            this.board.printBoard();
            move_counter++;
            //Creating a force exit
            if(move_counter > 2) { this.gStatus = Status.OVER; }
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
