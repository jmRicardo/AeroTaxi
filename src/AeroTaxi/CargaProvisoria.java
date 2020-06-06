package AeroTaxi;

public class CargaProvisoria {

    public static void main(String[] args) {

        Flight a = new Flight();
        a.setDate("8/12/2021");
        a.setDestiny(City.Cordoba);
        a.setOrigin(City.Santiago);
        a.setUsers(AeroTaxi.users);
        a.setPlane(AeroTaxi.airplanes.get(1));

        AeroTaxi.flights.add(a);

        AeroTaxi.saveFile(AeroTaxi.flightsPath,AeroTaxi.flights);

    }




}
