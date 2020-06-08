package AeroTaxi;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CargaProvisoria {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put(AeroTaxi.users.get(0).getDNI(),5);
        map.put(AeroTaxi.users.get(1).getDNI(),3);

        Flight a = new Flight();
        a.setDate(LocalDate.parse("12/10/2020",AeroTaxi.dateFormat));
        a.setDestiny(City.Santiago);
        a.setOrigin(City.Cordoba);
        a.setUsers(map);
        a.setPlane(AeroTaxi.airplanes.get(0));

        AeroTaxi.flights.add(a);

        AeroTaxi.saveFile(AeroTaxi.flightsPath,AeroTaxi.flights);

    }




}
