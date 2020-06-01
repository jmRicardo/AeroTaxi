package AeroTaxi;

import AeroTaxi.airplanes.Airplane;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flight {

    private List<User> users;
    private Airplane plane;
    private Date date;
    private int distance;

    public Flight(List<User> users, Airplane plane, Date date, int distance) {
        this.users = new ArrayList<User>();
        this.plane = plane;
        this.date = date;
        this.distance = distance;
    }

    public List<User> getUsers() {
        return users;
    }

    public double costOfFlight (){  //costo total de un vuelo
        return distance * plane.getCost() + (users.size() * 3500) + plane.getRate();
    }
}
