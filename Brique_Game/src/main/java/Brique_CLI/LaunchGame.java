package Brique_CLI;
import Game.*;

import java.util.Arrays;
import java.util.Scanner;

public class LaunchGame {
    public static void main(String[] args) {
        Player P1 = new Player("P1", Piece_Color.BLACK);
        Player P2 = new Player("P2", Piece_Color.WHITE);
        Scanner in = new Scanner(System.in);

        System.out.println("WELCOME TO BRIQUE GAME : ");
        System.out.println("Default settings are : P1 has White color and P2 has Black color ");
        System.out.println("would you like to change the default settings ? yes/No");
        if (in.next() == "yes")
        {
            Settings s1 = new Settings();
            s1.changeSettings(P1,P2);
        }

        Game game = new Game();
        game.startGame(P1, P2);
        Display.printBoard(game.getBoard());


        //here the player with BLACK makes his first move then White player's turn comes

        System.out.println("Would you like to use Pie Rule ? yes/No");
        if (in.next() == "yes")
        {
            Settings s2 = new Settings();
            s2.applyPieRule(P1,P2);
            //and swap the turn
        }






    }

}
