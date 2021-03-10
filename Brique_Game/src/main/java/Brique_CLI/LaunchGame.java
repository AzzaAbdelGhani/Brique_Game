package Brique_CLI;
import Game.*;

import java.util.Arrays;
import java.util.Scanner;

public class LaunchGame {

    public static void main(String[] args) {
        Game game = Display.startGame();
        Scanner scanner = new Scanner(System.in);
        Settings s = new Settings();
        int move_counter = 0;

        while(game.getStatus()== Status.ON){

            Display.printBoard(game.getBoard());
            System.out.println(game.getActivePlayer().getName() + "'s turn");

            if (move_counter == 1)
            {
                System.out.println("Would you like to use Pie Rule ? yes/no");
                String input2 = scanner.next();
                input2 = input2.toLowerCase();
                while (!input2.equals("yes") && !input2.equals("no") && !input2.equals("n") && !input2.equals("y")) {
                    System.out.println("Please enter yes or no : ");
                    input2 = scanner.next();
                }
                if (input2.equals("yes") || input2.equals("y"))
                {
                    s.applyPieRule(game.getActivePlayer(),game.getOtherPlayer());
                    game.getActivePlayer().setActive(false);
                    game.getOtherPlayer().setActive(true);
                    move_counter++;
                    continue;
                }
            }
            Coordinates coordinates = Display.userInput();
            Move move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer(), coordinates);
            while(!move.makeMove()){
                coordinates = Display.userInput();
                move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer(),coordinates);
            }
            move_counter++;

            if(move_counter > 28){
                if (game.getActivePlayer().checkPath())
                {
                    System.out.println("Congrats ! "+ game.getActivePlayer().getName() + " Wins !");
                    game.setStatus(Status.OVER);
                }
                if (game.getOtherPlayer().checkPath()) {
                    System.out.println("Congrats ! "+ game.getOtherPlayer().getName() + " Wins !");
                    game.setStatus(Status.OVER);
                }
            }

            System.out.println(game.getStatus());
        }
    }

}
