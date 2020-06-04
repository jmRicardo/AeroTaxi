package AeroTaxi.airplanes;

import AeroTaxi.AeroTaxi;
import com.fasterxml.jackson.annotation.JsonSubTypes;

public class Silver extends Airplane implements Catering{
    private String catering;

    public Silver(){super();}

    public Silver(int fuel, double cost, int capacity, double maxSpeed, Propulsion engine) {
        super(fuel, cost, capacity, maxSpeed, engine, 4000);
        this.catering = catering();
    }

    public String getCatering() {
        return catering;
    }

    public void setCatering(String catering) {
        this.catering = catering;
    }

    @Override
    public String catering() {
        return "CHORI CON MUCHO CHIMI!";
    }

    @Override
    public String toString() {
        return "Silver";
    }
}
