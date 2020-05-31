package AeroTaxi;

import AeroTaxi.airplanes.Airplane;

import java.util.ArrayList;
import java.util.List;

public class AeroTaxi implements Runnable{

    static private List<Airplane> airplanes;
    static private List<User> users;
    static private List<Flight> flights;

    public AeroTaxi(){
        airplanes = new ArrayList<>();
        users = new ArrayList<>();
        flights = new ArrayList<>();
    }

    public void probandoGitHub(){}

    @Override
    public void run() {

    }
}
