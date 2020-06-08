package AeroTaxi.graphic;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.core.User;
import AeroTaxi.core.Flight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    User find = null;
    DefaultListModel listModel;

    public CancelFlight() {

        root.setBackground(SwingUtil.backgroundColor);
        root.setForeground(SwingUtil.backgroundColor);



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
            find = AeroTaxi.searchUser(dniText.getText());
            if (find == null){
                showMessageDialog(null, "El usuario no existe!");
            }
            else{
                userFlights = AeroTaxi.searchFlyByUser(find);
                for (Flight flight : userFlights) {
                    listModel.addElement("Fecha: "+ flight.getDate()+
                                            "  Origen: "+ flight.getOrigin() +
                                                "  Destino: " + flight.getDestiny());
                }
            }

        });
        cancelButton.addActionListener(e -> {
            int x = flightList.getSelectedIndex();
            userFlights.get(x).getUsers().remove(find);
            AeroTaxi.saveFile(AeroTaxi.flightsPath,AeroTaxi.flights);

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
