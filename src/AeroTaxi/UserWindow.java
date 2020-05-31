package AeroTaxi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWindow extends JFrame {
    private JButton newUserButtton;
    private JButton existingUserButton;
    private JButton Back;
    private JPanel root;

    public UserWindow(){

        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                MainWindow mainwindow = new MainWindow();
            }
        });
        newUserButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                NewUser newuser = new NewUser();
            }
        });
        existingUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                ExistUser existuser = new ExistUser();
            }
        });
    }




}
