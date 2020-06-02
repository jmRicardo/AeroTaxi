package AeroTaxi.airplanes;

import AeroTaxi.AeroTaxi;

public class Gold extends Airplane {
    private String catering;
    private boolean wifi;

    public Gold(int fuel, double cost, int capacity, double maxSpeed, Propulsion engine, String catering, boolean wifi) {
        super(fuel, cost, capacity, maxSpeed, engine, 6000);
        this.catering = catering;
        this.wifi = wifi;
    }
}
