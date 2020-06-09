package AeroTaxi;

import AeroTaxi.core.AeroTaxi;
import AeroTaxi.core.City;
import AeroTaxi.core.Flight;
import AeroTaxi.utility.JSONUtily;
import AeroTaxi.utility.Path;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CargaProvisoria {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put(AeroTaxi.users.get(0).getDNI(),10);
        map.put(AeroTaxi.users.get(1).getDNI(),2);

        Flight a = new Flight();
        a.setDate(LocalDate.parse("12/10/2020",AeroTaxi.dateFormat));
        a.setDestiny(City.Buenos_Aires);
        a.setOrigin(City.Montevideo);
        a.setUsers(map);
        a.setPlane(AeroTaxi.airplanes.get(0));

        AeroTaxi.flights.add(a);

        JSONUtily.saveFile(Path.flightsPath,AeroTaxi.flights);

    }




}
