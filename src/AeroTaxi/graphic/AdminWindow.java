package AeroTaxi.graphic;

import AeroTaxi.AeroTaxi;
import AeroTaxi.User;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminWindow extends JFrame {

    private JPanel root;
    private JButton exitButton;
    private JList usersList;
    private JList list1;
    private JTextField dateField;
    private JButton searchButton;
    private JTextField textField1;
    private JTextField textField2;
    private DefaultListModel users;

    public AdminWindow(){

        ImageIcon img = new ImageIcon(AeroTaxi.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(800,640);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        exitButton.addActionListener(actionEvent -> dispose());

        users = new DefaultListModel();
        users.addAll(AeroTaxi.users);
        usersList.setModel(users);
        usersList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = usersList.getSelectedIndex();
                System.out.println("clickeaste el >> " + x);
            }
        });
    }
}
