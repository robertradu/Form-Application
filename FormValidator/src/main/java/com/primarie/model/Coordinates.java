package com.primarie.model;

public class Coordinates {
    protected double latitude;
    protected double longitude;
    protected double altitude;

    public Coordinates(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Coordinates() {
    }

    ;


    public String toString() {
        return "Latitudine: " + this.latitude + ", Longitudine: " + this.longitude + ", Altitudine: " + this.altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
}
