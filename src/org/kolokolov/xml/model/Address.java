package org.kolokolov.xml.model;

public class Address {
    private String street;
    private int house;
    
    public Address() {}
    
    public Address(String street, int house) {
        this.street = street;
        this.house = house;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return String.format("Address: %s str., %d", street, house); 
    }
}
