package AeroTaxi.airplanes;

import AeroTaxi.AeroTaxi;

public class Silver extends Airplane {
    private String catering;

    public Silver(int fuel, double cost, int capacity, double maxSpeed, Propulsion engine, String catering) {
        super(fuel, cost, capacity, maxSpeed, engine, 4000);
        this.catering = catering;
    }
}
