package AeroTaxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class ExistUser extends JFrame {


    private JTextField dniText;
    private JPanel root;
    private JLabel dniLabel;
    private JButton searchButton;
    private JLabel isValidLabel;
    private JLabel exampleLabel;
    private JButton backButton;

    public ExistUser(){

        ImageIcon img = new ImageIcon("aeroplano.png");
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        searchButton.addActionListener(actionEvent -> {
            dispose();
            NewFlight newflight = new NewFlight();
        });

        dniText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                checkStatus();
            }
        });

        dniText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                checkStatus();
            }
        });

        backButton.addActionListener(actionEvent -> {
            dispose();
            MainWindow mainwindow = new MainWindow();
        });
        dniText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                checkStatus();
            }
        });
    }


    private void checkStatus(){

         if (AeroTaxi.checkDni(dniText.getText())){
             isValidLabel.setForeground(Color.green);
             isValidLabel.setText("formato valido!");
             searchButton.setEnabled(true);
         }else{
             isValidLabel.setForeground(Color.red);
             isValidLabel.setText("formato invalido!");
             searchButton.setEnabled(false);
         }
    }


}
