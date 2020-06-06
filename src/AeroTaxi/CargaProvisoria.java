package AeroTaxi;

public class CargaProvisoria {

    public static void main(String[] args) {

        Flight a = new Flight();
        a.setDate("10/10/2020");
        a.setDestiny(City.Montevideo);
        a.setOrigin(City.Buenos_Aires);
        a.setUsers(AeroTaxi.users);
        a.setPlane(AeroTaxi.airplanes.get(0));

        AeroTaxi.flights.add(a);

        AeroTaxi.saveFile(AeroTaxi.flightsPath,AeroTaxi.flights);

    }




}
