package Game;

public class Move {
    private Board board;
    private Player currentPlayer, otherPlayer;
    private Coordinates coordinates;

    public Move(Board board, Player currentPlayer, Player otherPlayer, Coordinates coordinates){
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.otherPlayer = otherPlayer;
        this.coordinates = coordinates;
    }

    private void fillBoardandUpdateGraph(Coordinates coordinates) {
        board.getPos(coordinates).setPieceColor(currentPlayer.getColor());
        currentPlayer.getGraph().updateGraph(board,coordinates);
    }

    private boolean isEscortFilled(Coordinates coordinates){
        if (!board.isValidPos(coordinates)) return Boolean.FALSE;
        if (board.getPos(coordinates).getPieceColor() == currentPlayer.getColor()) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    private void fillEscorts(){
        Pos_Color color = board.getPos(coordinates).getPosColor();
        if(color == Pos_Color.LIGHT){
            if (isEscortFilled(coordinates.getDiagUp())) fillBoardandUpdateGraph(coordinates.getUp());
            if (isEscortFilled(coordinates.getDiagDown())) fillBoardandUpdateGraph(coordinates.getLeft());
        }
        else {
            if (isEscortFilled(coordinates.getDiagUp())) fillBoardandUpdateGraph(coordinates.getRight());
            if (isEscortFilled(coordinates.getDiagDown())) fillBoardandUpdateGraph(coordinates.getDown());
        }
    }

    public boolean makeMove(){
        if(board.isValidPos(coordinates) && board.getPos(coordinates).getPieceColor() == Piece_Color.BLANK){
            fillBoardandUpdateGraph(coordinates);
            fillEscorts();
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

