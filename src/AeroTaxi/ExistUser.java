package AeroTaxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class ExistUser extends JFrame {

    private static final String pattern = "\\d{1,2}\\.\\d{3}\\.\\d{3}";
    private static final Pattern dniPattern = Pattern.compile(pattern);

    private JTextField dniText;
    private JPanel root;
    private JLabel dniLabel;
    private JButton searchButton;
    private JLabel isValidLabel;
    private JLabel exampleLabel;

    public ExistUser(){

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
    }

    private void checkStatus(){

         if (checkDni()){
             isValidLabel.setForeground(Color.green);
             isValidLabel.setText("formato valido!");
             searchButton.setEnabled(true);
         }else{
             isValidLabel.setForeground(Color.red);
             isValidLabel.setText("formato invalido!");
             searchButton.setEnabled(false);
         }
    }

    private boolean checkDni()
    {
        return dniPattern.matcher(dniText.getText()).matches();
    }


}
