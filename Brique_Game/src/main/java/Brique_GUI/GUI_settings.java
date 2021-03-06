package Brique_GUI;

import Game.Graph;
import Game.Piece_Color;
import Game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI_settings extends JDialog {
    private JTextField P1Name = new JTextField(15);
    private JTextField P2Name = new JTextField(15);
    private JButton changeButton = new JButton("Change");
    public static int boardResolution = 720;
    public static final int boardSize = 15;

    public GUI_settings (JFrame frame, String title)
    {
        super(frame, title, false);
        JPanel panel = new JPanel(new GridLayout(5,2,5,5));
        panel.add(new JLabel("Player1 plays with BLACK : "));
        panel.add(new JLabel(" "));
        panel.add(new JLabel("Player1 Name: "));
        panel.add(P1Name);
        panel.add(new JLabel("Player2 plays with WHITE : "));
        panel.add(new JLabel(" "));
        panel.add(new JLabel("Player2 Name: "));
        panel.add(P2Name);
        panel.add(changeButton);

        add(panel);
        pack();
        setLocationRelativeTo(frame);
    }

    public String getP1Name()
    {
        return P1Name.getText();
    }
    public String getP2Name()
    {
        return P2Name.getText();
    }

    public void addChangeListener(ActionListener listener)
    {
        changeButton.addActionListener(listener);
    }

    public static Boolean applyPieRule(Player p1, Player p2)
    {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to apply Pie Rule ?", "choose", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            Piece_Color c = p1.getColor();
            p1.setColor(p2.getColor());
            p2.setColor(c);

            Graph g = p1.getGraph();
            p1.setGraph(p2.getGraph());
            p2.setGraph(g);
            return true;
        }
        return false;
    }
}
