package Brique_GUI;

import Game.Graph;
import Game.Piece_Color;
import Game.Player;

import javax.swing.*;

public class GUI_settings {

    public static Boolean applyPieRule(Player p1, Player p2)
    {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to apply Pie Rule ?", "choose", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            Piece_Color c = p1.getColor();
            p1.setPieceColor(p2.getColor());
            p2.setPieceColor(c);

            Graph g = p1.getGraph();
            p1.setGraph(p2.getGraph());
            p2.setGraph(g);
            return true;
        }
        return false;
    }
}
