package AeroTaxi;

import AeroTaxi.airplanes.Airplane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private List<User> users;
    private Airplane plane;
    private LocalDate date;
    private int distance;

    private boolean isDone;

    public Flight(){}

    public Flight(List<User> users, Airplane plane, LocalDate date, int distance) {
        this.users = new ArrayList<User>();
        this.plane = plane;
        this.date = date;
        this.distance = distance;
        this.isDone = false;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public double costOfFlight (){  //costo total de un vuelo
        return distance * plane.getCost() + (users.size() * 3500) + plane.getRate();
    }
}
