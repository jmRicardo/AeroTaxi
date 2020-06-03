package AeroTaxi.airplanes;

import AeroTaxi.AeroTaxi;

public class Gold extends Airplane implements Catering{
    private String catering;
    private boolean wifi;

    public Gold(int fuel, double cost, int capacity, double maxSpeed, Propulsion engine,boolean wifi) {
        super(fuel, cost, capacity, maxSpeed, engine, 6000);
        this.catering = catering();
        this.wifi = wifi;
    }

    public String getCatering() {
        return catering;
    }

    public void setCatering(String catering) {
        this.catering = catering;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public String catering() {
        return "MILANGA CON PURE PAPURRI!";
    }

    @Override
    public String toString() {
        return "Gold{" +
                "catering='" + catering + '\'' +
                ", wifi=" + wifi +
                "} " + super.toString();
    }
}
