package Brique_GUI;

import Game.*;

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
    private Game game;
    private int move_counter = 0;
    public BoardFrame(JFrame frame, Player P1, Player P2)
    {
        game = new Game();
        this.P1 = P1;
        this.P2 = P2;
        game.startGame(P1, P2);
        System.out.println(game.getActivePlayer().getName() + "'s turn");
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
            }
        }

        for (int r = boardSize-1; r >= 0; r--) { for(int c = 0; c < boardSize; c++){ this.board.add(this.grid[r][c]); } }

        setLocationRelativeTo(frame);
        board.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Move move = new Move();
        Boolean checkPie = ((move_counter == 0) ? true : false);
        Object source = e.getSource();
        PositionPanel temp = (PositionPanel) source;
        int x = temp.getRow();
        int y = temp.getCol();
        //System.out.println(x + " " + y);
        move.Move_GUI(game.getBoard(), game.getActivePlayer(), game.getOtherPlayer(), x, y);
        if(move.makeMove()) {
            move_counter++;
            temp.setPiece(game.getOtherPlayer().getColor());
            GUI_escorts(x,y);
            System.out.println(game.getActivePlayer().getName() + "'s turn");
        }
        if (checkPie) {
            if (GUI_settings.applyPieRule(P1, P2))
            {
                game.getActivePlayer().setActive(false);
                game.getOtherPlayer().setActive(true);
                System.out.println("Pie Rule Applied"); //Make changes for the pie rule
                System.out.println(game.getActivePlayer().getName() + "'s turn"); //Pie rule not applied correctly
            }
        }
        if(move_counter > 28){
            if(P1.checkPath())
            {
                JOptionPane.showMessageDialog(this,
                        "Congrats "+P1.getName()+" WINS !");
                game.setStatus(Status.P1_WINS);
            }
            if(P2.checkPath())
            {
                JOptionPane.showMessageDialog(this,
                        "Congrats "+P2.getName()+" WINS !");
                game.setStatus(Status.P2_WINS);
            }
        }
        if(game.getStatus() != Status.ON) {
            System.out.println(game.getStatus().getString());
            board.setVisible(false);
            WelcomeFrame g = new WelcomeFrame();
            g.setVisible(true);
        }

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

    public void GUI_escorts(int i, int j){
        Piece_Color current = this.grid[i][j].getPiece();
        Pos_Color color = this.grid[i][j].getColor();
        if ( i != boardSize-1 && j != boardSize-1 ) {
            if (current == this.grid[i+1][j+1].getPiece() && color == Pos_Color.LIGHT) { this.grid[i][j+1].setPiece(current); }
            if (current == this.grid[i+1][j+1].getPiece() && color == Pos_Color.DARK) { this.grid[i+1][j].setPiece(current); }
        }
        if ( i != 0 && j != 0 ){
            if (current == this.grid[i-1][j-1].getPiece() && color == Pos_Color.LIGHT) { this.grid[i-1][j].setPiece(current); }
            if (current == this.grid[i-1][j-1].getPiece() && color == Pos_Color.DARK){ this.grid[i][j-1].setPiece(current); }
        }
        if (i == boardSize-1 && color == Pos_Color.DARK && j != boardSize-1) { this.grid[i][j+1].setPiece(current); }
    }
}
