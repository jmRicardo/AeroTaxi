package AeroTaxi;

import javax.swing.*;
import java.awt.*;

public class NewFlight extends JFrame{
    private JLabel dateLabel;
    private JTextField fechaTextField;
    private JLabel destinyLabel;
    private JComboBox origenCombo;
    private JComboBox destinyCombo;
    private JTextField acompañantesTextField;
    private JButton okButton;
    private JLabel planeLabel;
    private JComboBox<String> airplanesCombo;
    private JButton buscarVuelosButton;
    private JPanel root;

    public NewFlight() throws HeadlessException {

        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        origenCombo.addItem("Buenos Aires");
        origenCombo.addItem("Cordoba");
        origenCombo.addItem("Santiago");
        origenCombo.addItem("Montevideo");

        destinyCombo.addItem("Buenos Aires");
        destinyCombo.addItem("Cordoba");
        destinyCombo.addItem("Santiago");
        destinyCombo.addItem("Montevideo");



    }
}
