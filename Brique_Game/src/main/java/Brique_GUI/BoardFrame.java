package Brique_GUI;

import Game.Game;
import Game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BoardFrame extends JFrame implements MouseListener {

    JFrame board ;
    Player P1,P2;
    ArrayList<PositionPanel> grid = new ArrayList<>();
    public BoardFrame(Player P1, Player P2)
    {
        Game game = new Game();
        this.P1 = P1;
        this.P2 = P2;
        game.startGame(P1, P2);
        this.board = new JFrame("Board");
        //this.board.setSize(600,600);
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board.setSize(new Dimension(720,720));
        this.board.setBackground(Color.BLACK);
        this.board.setLayout(new GridLayout(15,15,0,0));

        for (int r = 0; r < 15 ; r++)
        {
            for (int c = 0; c < 15; c++)
            {
                this.grid.add(new PositionPanel(r,c));
                this.board.add(this.grid.get(r*15+c));
            }
        }

        this.board.addMouseListener(this);
        board.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Hello");

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
