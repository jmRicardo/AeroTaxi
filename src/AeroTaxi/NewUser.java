package AeroTaxi;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class NewUser extends JFrame{
    private JTextField nameField;
    private JTextField lastField;
    private JTextField dniField;
    private JTextField ageField;
    private JButton okButton;
    private JPanel root;
    private JButton backButton;
    private JLabel isValidLabel;
    private JLabel exampleLabel;

    public NewUser(){

        ImageIcon img = new ImageIcon("aeroplano.png");
        this.setIconImage(img.getImage());
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
            String name = nameField.getText();
            String lastName = lastField.getText();
            String dni = dniField.getText();
            int age = Integer.parseInt(ageField.getText());
            User user = new User(name,lastName,dni,age);
            AeroTaxi.users.add(user);
//          se graba en el archivo
            AeroTaxi.save(AeroTaxi.usersPath, AeroTaxi.users);

        });


        KeyAdapter checker = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                checkStatus();
            }
        };


        dniField.addKeyListener(checker);
        nameField.addKeyListener(checker);
        ageField.addKeyListener(checker);
        lastField.addKeyListener(checker);











    }

    private void checkStatus(){

        boolean dniBool = AeroTaxi.checkDni(dniField.getText());
        boolean ageBool = AeroTaxi.checkAge(ageField.getText());
        boolean nameBool = !nameField.getText().isEmpty();
        boolean lastBool = !lastField.getText().isEmpty();

        if (dniBool && ageBool && nameBool && lastBool){
            isValidLabel.setForeground(Color.green);
            isValidLabel.setText("formato valido!");
            isValidLabel.setVisible(false);
            okButton.setEnabled(true);
        }else{
            isValidLabel.setForeground(Color.red);
            isValidLabel.setText("formulario incompleto!");
            okButton.setEnabled(false);
        }
    }






}
