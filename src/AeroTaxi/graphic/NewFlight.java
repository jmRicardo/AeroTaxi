package AeroTaxi.graphic;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.core.City;
import AeroTaxi.core.Flight;
import AeroTaxi.core.airplanes.Airplane;
import AeroTaxi.core.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        setVisible(true);

        airplanesCombo.setEnabled(true);
        destinyCombo.setEnabled(false);

        for (City c:City.values()){
            origenCombo.addItem(c.name());
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                MainWindow mainwindow = new MainWindow();
            }
        });

        //se espera que el combo box origen haga la accion, despues se remueve siempre los del combobox destino y seguido la series de if
        //selecciona la opcion del origen y despues se asignan los destinos correspondientes
        origenCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destinyCombo.setEnabled(true);
                destinyCombo.removeAllItems();
                if (origenCombo.getSelectedItem().equals(City.Montevideo)) {
                    destinyCombo.addItem(City.Cordoba);
                    destinyCombo.addItem(City.Santiago);
                    destinyCombo.addItem(City.Buenos_Aires);
                }

                if (origenCombo.getSelectedItem().equals(City.Buenos_Aires)) {
                    destinyCombo.addItem(City.Cordoba);
                    destinyCombo.addItem(City.Santiago);
                    destinyCombo.addItem(City.Montevideo);
                }

                if (origenCombo.getSelectedItem().equals(City.Cordoba)) {
                    destinyCombo.addItem(City.Buenos_Aires);
                    destinyCombo.addItem(City.Santiago);
                    destinyCombo.addItem(City.Montevideo);
                }

                if (origenCombo.getSelectedItem().equals(City.Santiago)) {
                    destinyCombo.addItem(City.Cordoba);
                    destinyCombo.addItem(City.Buenos_Aires);
                    destinyCombo.addItem(City.Montevideo);
                }
            }

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

    public void fillAirplanes(){
        for (Airplane a : AeroTaxi.airplanes){  //recorre la lista de aviones para mostrar en el Box
            airplanesCombo.addItem(a.toString());
        }
    }

}
