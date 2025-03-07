package view;

import model.Ferme;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FermeUI {
    private Ferme ferme;
    private JButton btnRecolter;

    public FermeUI() {
        ferme = new Ferme();
        JFrame frame = new JFrame("Ferme");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        frame.getContentPane().add(btnRecolter);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FermeUI();
    }
}