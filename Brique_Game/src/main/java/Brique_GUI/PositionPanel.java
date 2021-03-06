package Brique_GUI;

import Game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PositionPanel extends  JPanel {

    private int row;
    private int col;
    private Piece_Color pColor = Piece_Color.BLANK;
    private Pos_Color pos_color = Pos_Color.LIGHT;


    public PositionPanel(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.setSize(new Dimension(GUI_settings.boardResolution/GUI_settings.boardSize, GUI_settings.boardResolution/GUI_settings.boardSize));
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor((row + col) % 2 == 0 ? new java.awt.Color(204, 204, 204) : new java.awt.Color(153, 153,153));
        g.fillRect(0, 0, GUI_settings.boardResolution/GUI_settings.boardSize, GUI_settings.boardResolution/GUI_settings.boardSize);
        g.drawRect(0, 0, GUI_settings.boardResolution/GUI_settings.boardSize, GUI_settings.boardResolution/GUI_settings.boardSize);
        if((row + col)%2 != 0) { this.pos_color = Pos_Color.DARK; }
        if (pColor == Piece_Color.BLACK)
        {
            drawPiece(GUI_settings.boardResolution/GUI_settings.boardSize/4,GUI_settings.boardResolution/GUI_settings.boardSize/4,g,Color.BLACK);
        }
        else if (pColor == Piece_Color.WHITE)
        {
            drawPiece(GUI_settings.boardResolution/GUI_settings.boardSize/4,GUI_settings.boardResolution/GUI_settings.boardSize/4,g,Color.WHITE);
        }

    }

    public void drawPiece(int i, int j, Graphics g, Color pieceColor)
    {
        g.setColor(pieceColor);
        g.fillOval(i,j,GUI_settings.boardResolution/GUI_settings.boardSize/2,GUI_settings.boardResolution/GUI_settings.boardSize/2);
        g.setColor(Color.BLACK);
        g.drawOval(i,j,GUI_settings.boardResolution/GUI_settings.boardSize/2,GUI_settings.boardResolution/GUI_settings.boardSize/2);
    }

    public void setPiece(Piece_Color pColor) {
        this.pColor = pColor;
        repaint();
    }

    public Piece_Color getPiece() { return this.pColor; }
    public Pos_Color getColor() { return this.pos_color; }
    public int getRow() { return this.row;}
    public int getCol() { return this.col;}

}
