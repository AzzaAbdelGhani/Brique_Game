package Brique_CLI;

import Game.*;

public class Display {

    private static final int size = 15;

    public static void printBoard(Board board){
        System.out.print("   ");
        for (int i = size-1 ; i >= 0; i--) {
            System.out.print(" " + (char) ('o' - i));
        }
        System.out.println(" ");
        for (int i = size-1; i >= 0; i--) {
            if (i < 9) System.out.print(" ");
            System.out.print(i + 1 + " ");
            for (int j = 0; j < size; j = j + 1) {
                if (board.getGrid(i,j).getPieceColor() == Piece_Color.BLACK) {
                    System.out.print("|" + "B");
                } else if (board.getGrid(i,j).getPieceColor() == Piece_Color.WHITE) {
                    System.out.print("|" + "W");
                } else if ((i + j) % 2 == 0) {
                    System.out.print("| ");
                } else {
                    System.out.print("|#");
                }
            }
            System.out.print("| ");
            System.out.println(i+1);
        }
        System.out.print("   ");
        for (int i = size-1; i >= 0; i--) {
            System.out.print(" " + (char) ('o' - i ));
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------");

    }
}
