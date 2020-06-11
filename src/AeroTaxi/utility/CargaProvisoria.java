package AeroTaxi.utility;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.core.City;
import AeroTaxi.core.Flight;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CargaProvisoria {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put(AeroTaxi.users.get(0).getDNI(),1);
        map.put(AeroTaxi.users.get(1).getDNI(),1);

        Flight a = new Flight();
        a.setDate(LocalDate.parse("05/05/2020",AeroTaxi.dateFormat));
        a.setDestiny(City.Santiago);
        a.setOrigin(City.Cordoba);
        a.setUsers(map);
        a.setPlane(AeroTaxi.airplanes.get(1));

        AeroTaxi.flights.add(a);

        JSONUtily.saveFile(Path.flightsPath,AeroTaxi.flights);
    }
}
