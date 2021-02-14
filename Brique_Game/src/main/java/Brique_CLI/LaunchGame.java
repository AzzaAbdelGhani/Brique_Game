package Brique_CLI;
import Game.*;

import java.util.Arrays;
import java.util.Scanner;

public class LaunchGame {
    public static void main(String[] args) {
        Player P1 = new Player("P1", Piece_Color.BLACK);
        Player P2 = new Player("P2", Piece_Color.WHITE);
        Scanner scanner = new Scanner(System.in);
        Settings s = new Settings();

        System.out.println("WELCOME TO BRIQUE GAME : ");
        System.out.println("Default settings are : P1 has White color and P2 has Black color ");
        System.out.println("would you like to change the default settings ? yes/No");
        String input1 = scanner.next();
        if (input1.equals("yes"))
        {
            s.changeSettings(P1,P2);
        }

        Game game = new Game();
        game.startGame(P1, P2);
        int move_counter = 0;

        while(game.getStatus()== Status.ON){

            Display.printBoard(game.getBoard());
            System.out.println(game.getActivePlayer().getName() + "'s turn");

            if (move_counter == 1)
            {
                System.out.println("Would you like to use Pie Rule ? yes/no");
                String input2 = scanner.next();
                while (!input2.equals("yes") && !input2.equals("no")) {
                    System.out.println("Please enter yes or no : ");
                    input2 = scanner.next();
                }
                if (input2.equals("yes"))
                {
                    s.applyPieRule(P1,P2);
                    game.getActivePlayer().setActive(false);
                    game.getOtherPlayer().setActive(true);
                    move_counter++;
                    continue;
                }
            }
            Move move = new Move();
            move.Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer());
            while(!move.makeMove()){ move.Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer()); }
            move_counter++;

            if(move_counter > 28){
                if (P1.checkPath()) game.setStatus(Status.P1_WINS);
                if (P2.checkPath()) game.setStatus(Status.P2_WINS);
                if(move_counter > 225)  game.setStatus(Status.OVER);
            }

            System.out.println(game.getStatus());
        }
    }

}
