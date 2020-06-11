package AeroTaxi.graphic;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.core.User;
import AeroTaxi.utility.JSONUtily;
import AeroTaxi.utility.Path;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private JLabel nameLabel;
    private JLabel lastLabel;
    private JLabel dniLabel;
    private JLabel ageLabel;
    private JPanel logoPanel;
    private JLabel image;

    public NewUser(){

        exampleLabel.setForeground(SwingUtil.textColor);
        okButton.setForeground(SwingUtil.textColor);
        backButton.setForeground(SwingUtil.textColor);
        nameLabel.setForeground(SwingUtil.textColor);
        lastLabel.setForeground(SwingUtil.textColor);
        dniLabel.setForeground(SwingUtil.textColor);
        ageLabel.setForeground(SwingUtil.textColor);
        nameField.setForeground(SwingUtil.textColor);
        lastField.setForeground(SwingUtil.textColor);
        dniField.setForeground(SwingUtil.textColor);
        ageField.setForeground(SwingUtil.textColor);

        okButton.setBackground(SwingUtil.buttonColor);
        backButton.setBackground(SwingUtil.buttonColor);

        image.setIcon(new ImageIcon(Path.logoPath));
        ImageIcon img = new ImageIcon(Path.iconPath);
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

            if (AeroTaxi.users.contains(user.getDNI()))
            AeroTaxi.users.add(user);
//          se graba en el archivo
            JSONUtily.saveFile(Path.usersPath, AeroTaxi.users);
            dispose();
            new NewFlight(user);

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
