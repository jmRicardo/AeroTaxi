package AeroTaxi.graphic;

import AeroTaxi.AeroTaxi;
import AeroTaxi.User;
import AeroTaxi.Flight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class CancelFlight extends JFrame {
    private JPanel root;
    private JButton backButton;
    private JButton cancelButton;
    private JTextField dniText;
    private JLabel dniLabel;
    private JLabel exampleLabel;
    private JButton searchButton;
    private JLabel isValidLabel;
    private JList flightList;

    private List<Flight> userFlights;
    DefaultListModel listModel;

    public CancelFlight() {

        ImageIcon img = new ImageIcon(AeroTaxi.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

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

        flightList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        flightList.setLayoutOrientation(JList.VERTICAL);
        flightList.setVisibleRowCount(-1);

        /// lista de vuelos por DNI, la lista se actualiza y automaticamente se ve reflejada en la JList
        listModel = new DefaultListModel();
        flightList.setModel(listModel);


        searchButton.addActionListener(e -> {
            User find = AeroTaxi.searchUser(dniText.getText());
            if (find == null){
                showMessageDialog(null, "El usuario no existe!");
            }
            else{
                userFlights = searchFlightsByUser(user);
                for (Flight flight : userFlights) {
                    listModel.addElement(flight);
                }
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