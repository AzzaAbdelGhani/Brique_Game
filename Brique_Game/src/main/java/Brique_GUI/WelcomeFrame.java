package Brique_GUI;

import Game.Piece_Color;
import Game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame implements ActionListener {

    private JButton startgame;
    private JFrame main = new JFrame("Brique Game");
    Player P1 = new Player("P1", Piece_Color.BLACK);
    Player P2 = new Player("P2", Piece_Color.WHITE);

    public WelcomeFrame()
    {
        main.setSize(600,600);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.startgame = new JButton("Start Game");
        startgame.addActionListener(this);
        main.add(startgame, BorderLayout.CENTER);
        main.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == startgame)
        {
            main.setVisible(false);
            new BoardFrame(P1,P2);
        }
    }

    public static void main(String args[])
    {
        WelcomeFrame g = new WelcomeFrame();


    }
}
