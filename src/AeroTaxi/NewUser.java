package AeroTaxi;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUser extends JFrame{
    private JTextField nameField;
    private JTextField lastField;
    private JTextField dniField;
    private JTextField ageField;
    private JButton okButton;
    private JPanel root;
    private JButton backButton;

    public NewUser(){

        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        backButton.addActionListener(actionEvent -> {
            dispose();
            MainWindow mainwindow = new MainWindow();
        });

        okButton.addActionListener(e -> {

        });
    }
}
