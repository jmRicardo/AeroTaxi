package AeroTaxi.core;

import AeroTaxi.core.airplanes.Airplane;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Flight {

    private Map<String,Integer> users;

    private Airplane plane;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    private City departure;
    private City destiny;

    private int costPerKm;

    private boolean isDone;

    public Flight(Airplane plane, LocalDate date, City departure, City destiny) {
        this.users = new HashMap<>();
        this.plane = plane;
        this.date = date;
        this.departure = departure;
        this.destiny = destiny;
        this.isDone = false;
        this.costPerKm = new Random().nextInt(150)+150;
    }

    public Flight() {
        this.users = new HashMap<>();
        this.isDone = false;
        this.costPerKm = new Random().nextInt(150)+150;
    }

    public void addUsers(String user,Integer total) {
        this.users.put(user,total);
    }

    public City getDeparture() {
        return departure;
    }

    public void setDeparture(City departure) {
        this.departure = departure;
    }

    public int getCostPerKm() {
        return costPerKm;
    }

    public void setCostPerKm(int costPerKm) {
        this.costPerKm = costPerKm;
    }

    public Map<String, Integer> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Integer> users) {
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

    public City getOrigin() {
        return departure;
    }

    public void setOrigin(City origin) {
        this.departure = origin;
    }

    public City getDestiny() {
        return destiny;
    }

    public void setDestiny(City destiny) {
        this.destiny = destiny;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Double costPerUser(User user){
        return (double) ((AeroTaxi.calculateDistance(departure, destiny)*costPerKm) + (users.get(user.getDNI())*3500) + plane.getRate());
    }
    /*
    (Cantidad de kms * Costo del km) + (cantidad de pasajeros * 3500) + (Tarifa del tipo
    de avión)*/


    @Override
    public String toString() {
        return "Flight{" +
                "users=" + users +
                ", plane=" + plane +
                ", date='" + date + '\'' +
                ", departure=" + departure +
                ", destiny=" + destiny +
                ", isDone=" + isDone +
                '}';
    }
}
