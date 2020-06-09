package AeroTaxi.graphic;

import AeroTaxi.utility.Path;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserWindow extends JFrame {

    private JButton newUserButtton;
    private JButton existingUserButton;
    private JPanel root;
    private JButton backButton;
    private JPanel logoPanel;
    private JLabel image;

    public UserWindow(){

        root.setBackground(SwingUtil.backgroundColor);
        newUserButtton.setBackground(SwingUtil.buttonColor);
        newUserButtton.setForeground(SwingUtil.textColor);
        existingUserButton.setBackground(SwingUtil.buttonColor);
        existingUserButton.setForeground(SwingUtil.textColor);
        backButton.setBackground(SwingUtil.buttonColor);
        backButton.setForeground(SwingUtil.textColor);

        image.setIcon(new ImageIcon(Path.logoPath));

        ImageIcon img = new ImageIcon(Path.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        backButton.addActionListener(new ActionListener() {
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
