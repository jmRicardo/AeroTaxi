package AeroTaxi;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CargaProvisoria {

    public static void main(String[] args) {

        /*Flight a = new Flight();
        a.setDate(LocalDate.of(2021,7,5));
        a.setDestiny(City.Cordoba);
        a.setOrigin(City.Santiago);
        a.setUsers(AeroTaxi.users);
        a.setPlane(AeroTaxi.airplanes.get(1));

        AeroTaxi.flights.add(a);

        AeroTaxi.saveFile(AeroTaxi.flightsPath,AeroTaxi.flights);*/

        LocalDate ld = LocalDate.of(2021,7,5);

        List<Flight> list = AeroTaxi.flights.stream().filter(x -> x.getDate().equals(ld)).collect(Collectors.toList());

        System.out.println(list);

    }




}
