package Brique_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame implements ActionListener {

    private JButton startgame;
    private JFrame main = new JFrame("Brique Game");

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
            new BoardFrame();
        }
    }

    public static void main(String args[])
    {
        WelcomeFrame g = new WelcomeFrame();


    }
}
