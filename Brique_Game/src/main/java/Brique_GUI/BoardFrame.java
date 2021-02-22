package Brique_GUI;

import Game.Game;
import Game.Piece_Color;
import Game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BoardFrame extends JFrame implements MouseListener {

    private JFrame board;
    private Player P1,P2;
    private static int boardResolution = 720;
    private static final int boardSize = 15;
    private PositionPanel[][] grid = new PositionPanel[boardSize][boardSize];
    public BoardFrame(Player P1, Player P2)
    {
        Game game = new Game();
        this.P1 = P1;
        this.P2 = P2;
        game.startGame(P1, P2);
        this.board = new JFrame("Board");
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board.setBackground(Color.BLACK);
        this.board.setLayout(new GridLayout(boardSize, boardSize, 0, 0));
        this.board.setSize(new Dimension(boardResolution,boardResolution));
        this.board.setResizable(false);
        for (int r = 0; r < boardSize ; r++)
        {
            for (int c = 0; c < boardSize; c++)
            {
                this.grid[r][c] = new PositionPanel(r, c);
                this.grid[r][c].addMouseListener(this);
                this.board.add(this.grid[r][c]);
            }
        }

        //this.board.addMouseListener(this);
        board.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        PositionPanel temp = (PositionPanel) source;
        temp.setPiece(Piece_Color.BLACK);
        temp.repaint();
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
