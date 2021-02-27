package Brique_GUI;

import Game.Piece_Color;
import Game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame implements ActionListener {

    private JButton startGame;
    private JButton changeSettings;
    private JLabel welcomeMessage;
    private JLabel defaultSettingsMessage;
    Player P1 = new Player("P1", Piece_Color.BLACK);
    Player P2 = new Player("P2", Piece_Color.WHITE);
    private GUI_settings changeDialog = new GUI_settings(this,"Change Settings");

    public WelcomeFrame()
    {
        setResizable(false);
        setLayout(new BorderLayout());
        JLabel background = new JLabel((new ImageIcon("C:/Users/user/Desktop/DSSC program/Second year/First Semester/Software_Development/Brique_Game/Brique_Game/src/images/bg.jpg")));
        background.setLayout(new FlowLayout(FlowLayout.CENTER, 1,180));
        add(background,BorderLayout.CENTER);

        JPanel basePanel = new JPanel();
        basePanel.setOpaque(false);
        basePanel.setLayout(new GridLayout(5, 1, 5, 15));

        startGame = new JButton("Start Game");
        startGame.setFont(new Font("Arial", Font.PLAIN, 20));
        startGame.setForeground(Color.GREEN);
        startGame.setBorderPainted(false);
        startGame.setFocusPainted(false);
        startGame.setContentAreaFilled(false);
        changeSettings = new JButton("Change Settings");
        changeSettings.setFont(new Font("Arial", Font.PLAIN, 20));
        changeSettings.setForeground(Color.CYAN);
        changeSettings.setBorderPainted(false);
        changeSettings.setFocusPainted(false);
        changeSettings.setContentAreaFilled(false);
        welcomeMessage = new JLabel("Welcome To Brique Game :) ");
        welcomeMessage.setFont(new Font("Serif", Font.ITALIC, 24));
        welcomeMessage.setForeground(Color.WHITE);
        defaultSettingsMessage = new JLabel("Default Settings : P1 (BLACK) vs P2 (WHITE)");
        defaultSettingsMessage.setFont(new Font("Serif", Font.ITALIC, 15));
        defaultSettingsMessage.setForeground(Color.lightGray);
        startGame.addActionListener(this);
        changeSettings.addActionListener(this);
        basePanel.add(welcomeMessage);
        basePanel.add(defaultSettingsMessage);
        basePanel.add(changeSettings);
        basePanel.add(startGame);
        background.add(basePanel);

        setTitle("Brique");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == startGame)
        {
            setVisible(false);
            new BoardFrame(this,P1,P2);
        }
        if (e.getSource() == changeSettings)
        {
            if(!changeDialog.isVisible()) changeDialog.setVisible(true);
            changeDialog.addChangeListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    P1.setName(changeDialog.getP1Name());
                    P2.setName(changeDialog.getP2Name());
                    changeDialog.setVisible(false);
                }
            });
        }

    }

    public static void main(String args[])
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
