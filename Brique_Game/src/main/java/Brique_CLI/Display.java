package Brique_CLI;

import Game.*;

import java.util.Scanner;

public class Display {

    private static final int size = 15;

    public static Game startGame()
    {
        Player P1 = new Player("P1", Piece_Color.BLACK);
        Player P2 = new Player("P2", Piece_Color.WHITE);
        Settings s = new Settings();
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO BRIQUE GAME : ");
        System.out.println("Default settings are : P1 has White color and P2 has Black color ");
        System.out.println("would you like to change the default settings ? yes/No");
        String input1 = scanner.next();
        input1 = input1.toLowerCase();
        while (!input1.equals("yes") && !input1.equals("no") && !input1.equals("y") && !input1.equals("n")) {
            System.out.println("Please enter yes or no : ");
            input1 = scanner.next();
        }
        if (input1.equals("yes") || input1.equals("y"))
        {
            s.changeSettings(P1,P2);
        }

        Game game = new Game();
        game.startGame(P1, P2);
        return game;
    }

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
                if (board.getPos(i,j).getPieceColor() == Piece_Color.BLACK) {
                    System.out.print("|" + "B");
                } else if (board.getPos(i,j).getPieceColor() == Piece_Color.WHITE) {
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
