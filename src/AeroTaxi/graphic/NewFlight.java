package AeroTaxi.graphic;

import AeroTaxi.core.*;
import AeroTaxi.core.airplanes.*;
import AeroTaxi.utility.JSONUtily;
import AeroTaxi.utility.Path;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static javax.swing.JOptionPane.showMessageDialog;

public class NewFlight extends JFrame{
    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel destinyLabel;
    private JComboBox origenCombo;
    private JComboBox destinyCombo;
    private JTextField companionField;
    private JButton okButton;
    private JLabel planeLabel;
    private JComboBox airplanesCombo;
    private JButton searchButton;
    private JPanel root;
    private JButton backButton;
    private JTextField capa;
    private JTextField totalCost;

    List<Flight> list;


    public NewFlight(User user) throws HeadlessException {

        ImageIcon img = new ImageIcon(Path.iconPath);
        this.setIconImage(img.getImage());
        add(root);
        setResizable(false);
        setSize(300,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);;

        for (City c:City.values()){
            origenCombo.addItem(c.name());
            destinyCombo.addItem(c.name());
        }

        fillAirplanes();

        origenCombo.setSelectedIndex(0);
        destinyCombo.setSelectedIndex(1);

        origenCombo.addActionListener(e -> {
            while (origenCombo.getSelectedIndex() == destinyCombo.getSelectedIndex())
                destinyCombo.setSelectedIndex(new Random().nextInt(City.values().length));
        });

        destinyCombo.addActionListener(e -> {
            while (origenCombo.getSelectedIndex() == destinyCombo.getSelectedIndex())
                origenCombo.setSelectedIndex(new Random().nextInt(City.values().length));
        });

        backButton.addActionListener(actionEvent -> {
            dispose();
            new MainWindow();
        });

        okButton.addActionListener(e -> {

            Flight flight = new Flight();
            AeroTaxi.flights.add(flight);
            JSONUtily.saveFile(Path.flightsPath,AeroTaxi.flights);
            dispose();
            new MainWindow();
        });

        searchButton.addActionListener(e -> {
        });

        companionField.setText("0"); //necesario para que funcione el calculo del costo del vuelo

        dateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                checkDateStatus();
            }
        });
    }

    public void fillAirplanes(Airplane... delete){
        for (Airplane a : AeroTaxi.airplanes){  //recorre la lista de aviones para mostrar en el Box
            airplanesCombo.addItem(a.toString());
        }
    }

    public void checkDateStatus()
    {
        String date = dateField.getText();
        boolean enabled =  AeroTaxi.checkDate(date);
        activeFields(enabled);
        if (enabled){
            LocalDate localDate = LocalDate.parse(date,AeroTaxi.dateFormat);
            boolean valid = AeroTaxi.checkValidDate(localDate);
            if (valid){
                list = AeroTaxi.searchFlyByDate(localDate);
            }
            else{
                showMessageDialog(null, "Fecha invalida / ya paso!");
                dateField.setText("");
                activeFields(false);
            }
        }
    }

    public void activeFields(Boolean enabled)
    {
        searchButton.setEnabled(enabled);
        airplanesCombo.setEnabled(enabled);
        origenCombo.setEnabled(enabled);
        destinyCombo.setEnabled(enabled);
        companionField.setEnabled(enabled);
    }




}
