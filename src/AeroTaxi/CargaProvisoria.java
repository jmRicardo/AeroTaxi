package AeroTaxi;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CargaProvisoria {

    public static void main(String[] args) {

        Flight a = new Flight();
        a.setDate(LocalDate.parse("12/10/2020",AeroTaxi.dateFormat));
        a.setDestiny(City.Santiago);
        a.setOrigin(City.Cordoba);
        a.setUsers(AeroTaxi.users);
        a.setPlane(AeroTaxi.airplanes.get(0));

        AeroTaxi.flights.add(a);

        AeroTaxi.saveFile(AeroTaxi.flightsPath,AeroTaxi.flights);

    }




}
