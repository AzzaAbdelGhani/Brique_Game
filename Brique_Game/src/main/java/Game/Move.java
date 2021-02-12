package Game;
import java.util.Scanner;

public class Move {
    Board board;
    Player currentPlayer, otherPlayer;
    int x, y, size;

    public void Move(Board board, Player currentPlayer, Player otherPlayer){
        this.board = board;
        this.size = this.board.getSize();
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
        System.out.println(currentPlayer.getName() + "'s turn");
        System.out.print("Enter the coordinates:");
        Scanner sc = new Scanner(System.in);
        this.y = sc.nextInt() - 1;
        this.x = sc.nextInt() - 1;
    }

    public boolean makeMove(){
        if(this.board.isValidPos(this.x,this.y) && this.board.getPosFill(this.x ,this.y) == Piece_Color.BLANK){
            this.board.fillPos(this.x, this.y, this.currentPlayer.getColor());
            this.board.fillEscorts(this.x,this.y);
            currentPlayer.updateGraph(this.board, this.x, this.y);
            currentPlayer.setActive(Boolean.FALSE);
            otherPlayer.setActive(Boolean.TRUE);
            return Boolean.TRUE;
        }
        else{
            System.out.println("Invalid Coordinates, please enter again: ");
            return Boolean.FALSE;
        }
    }
}

