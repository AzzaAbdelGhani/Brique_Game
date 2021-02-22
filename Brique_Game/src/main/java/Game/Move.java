package Game;
import java.util.Scanner;

public class Move {
    private Board board;
    private Player currentPlayer, otherPlayer;
    private int x, y, size;

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public void Move(Board board, Player currentPlayer, Player otherPlayer){
        this.board = board;
        this.size = this.board.getSize();
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
        System.out.print("Enter the coordinates:");
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        this.y = (int) a - 97;
        this.x = sc.nextInt() - 1;
    }

    public void Move_GUI(Board board, Player currentPlayer, Player otherPlayer, int x, int y){
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
        this.x = x;
        this.y = y;
    }

    public void fillBoardandUpdateGraph(int a, int b, Piece_Color color) {
        this.board.fillPos(a, b, color);
        this.currentPlayer.updateGraph(this.board,a,b);
    }

    public void fillEscorts(int i, int j){
        Piece_Color current = this.board.getPosFill(i,j);
        Pos_Color color = this.board.getPosColor(i,j);
        if ( i != size-1 && j != size-1 ) {
            if (current == this.board.getPosFill(i+1,j+1) && color == Pos_Color.LIGHT) { fillBoardandUpdateGraph(i,j+1, current); }
            if (current == this.board.getPosFill(i+1,j+1) && color == Pos_Color.DARK) { fillBoardandUpdateGraph(i+1, j, current); }
        }
        if ( i != 0 && j != 0 ){
            if (current == this.board.getPosFill(i-1,j-1) && color == Pos_Color.LIGHT) { fillBoardandUpdateGraph(i-1, j, current); }
            if (current == this.board.getPosFill(i-1,j-1) && color == Pos_Color.DARK){ fillBoardandUpdateGraph(i, j-1, current); }
        }
        if (i == size-1 && color == Pos_Color.DARK) { fillBoardandUpdateGraph(i, j+1, current); }
    }

    public boolean makeMove(){
        if(this.board.isValidPos(this.x,this.y) && this.board.getPosFill(this.x ,this.y) == Piece_Color.BLANK){
            fillBoardandUpdateGraph(this.x, this.y, this.currentPlayer.getColor());
            fillEscorts(this.x,this.y);
            this.currentPlayer.setActive(Boolean.FALSE);
            this.otherPlayer.setActive(Boolean.TRUE);
            return Boolean.TRUE;
        }
        else{
            System.out.println("Invalid Coordinates, please enter again: ");
            return Boolean.FALSE;
        }
    }
}

