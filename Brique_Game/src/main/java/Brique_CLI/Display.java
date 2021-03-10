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

    public static boolean userInputPieRule(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to use Pie Rule ? yes/no");
        String input2 = scanner.next();
        input2 = input2.toLowerCase();
        while (!input2.equals("yes") && !input2.equals("no") && !input2.equals("n") && !input2.equals("y")) {
            System.out.println("Please enter yes or no : ");
            input2 = scanner.next();
        }
        if (input2 == "yes" || input2 == "y") return true;

        return false;
    }
    public static Coordinates userInputCoordinates(){
        System.out.print("Please enter the coordinates:\t");
        Scanner scanner = new Scanner(System.in);
        char a = scanner.next().charAt(0);
        int y = (int) a - 97;
        int x = scanner.nextInt() - 1;
        return new Coordinates(x,y);
    }

    public static void victoryDisplay(Player P){
        System.out.println("GAME OVER");
        System.out.println(P.getName() + "wins!" + "Congrats");
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
                Coordinates coordinates = new Coordinates(i,j);
                if (board.getPos(coordinates).getPieceColor() == Piece_Color.BLACK) {
                    System.out.print("|" + "B");
                } else if (board.getPos(coordinates).getPieceColor() == Piece_Color.WHITE) {
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
