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
    private static int panelResolution = 48;

    public PositionPanel(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.setSize(new Dimension(panelResolution, panelResolution));
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor((row + col) % 2 == 0 ? new java.awt.Color(204, 204, 204) : new java.awt.Color(153, 153,153));
        g.fillRect(0, 0, panelResolution, panelResolution);
        g.drawRect(0, 0, panelResolution, panelResolution);
        if((row + col)%2 != 0) { this.pos_color = Pos_Color.DARK; }
        if (pColor == Piece_Color.BLACK)
        {
            drawPiece(panelResolution/4,panelResolution/4,g,Color.BLACK);
        }
        else if (pColor == Piece_Color.WHITE)
        {
            drawPiece(panelResolution/4,panelResolution/4,g,Color.WHITE);
        }

    }

    public void drawPiece(int i, int j, Graphics g, Color pieceColor)
    {
        g.setColor(pieceColor);
        g.fillOval(i,j,panelResolution/2,panelResolution/2);
        g.setColor(Color.BLACK);
        g.drawOval(i,j,panelResolution/2,panelResolution/2);
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
