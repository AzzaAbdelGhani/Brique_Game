package Brique_CLI;
import Game.*;

import java.util.Scanner;

public class LaunchGame {

    public static void run() {
        Game game = Display.startGame();
        Settings s = new Settings();
        int move_counter = 0;

        while(game.getStatus()== Status.ON){

            Display.printBoard(game.getBoard());
            System.out.println(game.getActivePlayer().getName() + "'s turn");

            if (move_counter == 1 && Display.userInputPieRule())
            {
                s.applyPieRule(game.getActivePlayer(),game.getOtherPlayer());
                move_counter++;
                continue;
            }

            Move move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer(), Display.userInputCoordinates());
            while(!move.makeMove()){  move = new Move(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer(), Display.userInputCoordinates()); }
            move_counter++;

            if(move_counter > 28){
                if (game.getActivePlayer().checkPath())
                {
                    Display.victoryDisplay(game.getActivePlayer());
                    game.setStatus(Status.OVER);
                }
                if (game.getOtherPlayer().checkPath()) {
                    Display.victoryDisplay(game.getOtherPlayer());
                    game.setStatus(Status.OVER);
                }
            }
        }
    }

}
