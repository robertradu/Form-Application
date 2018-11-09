package com.primarie.model;

public class Location {
    protected String description;
    protected Coordinates coordinates;
    protected Address adress;


    public Location(String description, Coordinates coordinates, Address adress) {
        this.description = description;
        this.coordinates = coordinates;
        this.adress = adress;
    }

    public Location() {
    }

    ;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Address getAddress() {
        return adress;
    }

    public void setAddress(Address adress) {
        this.adress = adress;
    }
}
