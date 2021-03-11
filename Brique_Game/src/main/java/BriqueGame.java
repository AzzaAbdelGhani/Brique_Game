import Brique_CLI.LaunchGame;
import Brique_GUI.WelcomeFrame;

import java.awt.*;
import java.util.Scanner;

public class BriqueGame {

    public static void main(String[] args) {
        System.out.println("WELCOME TO BRIQUE GAME : ");
        System.out.println("Would you like to play in CLI or GUI ?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        input = input.toLowerCase();
        while (!input.equals("cli") && !input.equals("gui")) {
            System.out.println("Please enter cli or gui : ");
            input = scanner.next();
        }
        if (input.equals("cli"))
        {
            LaunchGame.run();
        }
        else if (input.equals("gui"))
        {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        WelcomeFrame g = new WelcomeFrame();
                        g.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
