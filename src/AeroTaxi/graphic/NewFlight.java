package AeroTaxi.graphic;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.core.City;
import AeroTaxi.core.Flight;
import AeroTaxi.core.airplanes.Airplane;
import AeroTaxi.core.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    //asd
    public NewFlight(User user) throws HeadlessException {

        ImageIcon img = new ImageIcon(AeroTaxi.iconPath);
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
            MainWindow mainwindow = new MainWindow();
        });

        okButton.addActionListener(e -> {

                Flight flight = new Flight();
                AeroTaxi.flights.add(flight);
                AeroTaxi.saveFile(AeroTaxi.flightsPath,AeroTaxi.flights);
        });
        searchButton.addActionListener(e -> {

            String origin = origenCombo.getSelectedItem().toString();
            String arrival = destinyCombo.getSelectedItem().toString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        });

        companionField.setText("0"); //necesario para que funcione el calculo del costo del vuelo

        airplanesCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = airplanesCombo.getSelectedIndex();
                //capa.setText(""+i);
                Airplane aux = AeroTaxi.airplanes.get(i);

                //capa.setText("Hay");

                City origen = (City) origenCombo.getSelectedItem();
                City destino = (City) destinyCombo.getSelectedItem();

                //capa.setText(origen);

                //LocalDate date = LocalDate.parse(dateField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                //Flight auxi = new Flight(aux, date, origen, destino);
                int compa = Integer.parseInt(companionField.getText());  //problema si es null
            }
        });

        dateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String date = dateField.getText();
                boolean enabled =  AeroTaxi.checkDate(date);
                searchButton.setEnabled(enabled);
                if (enabled){
                    LocalDate localDate = LocalDate.parse(date,AeroTaxi.dateFormat);
                    List<Flight> list = AeroTaxi.searchFlyByDate(localDate);
                }
            }
        });

    }

    public void fillComboCities(JComboBox fill,City value){
        for (City c:City.values()){
            if (!c.equals(value))
                fill.addItem(c.name());
        }
    }

    public void fillAirplanes(){
        for (Airplane a : AeroTaxi.airplanes){  //recorre la lista de aviones para mostrar en el Box
            airplanesCombo.addItem(a.toString());
        }
    }




}
