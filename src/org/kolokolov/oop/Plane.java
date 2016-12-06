package org.kolokolov.oop;

import org.kolokolov.oop.enums.AirTransportType;

public class Plane extends AirTransport {

    public Plane(String mark, String model) {
        super(mark, model, AirTransportType.PLANE);
        System.out.println("Plane concrete class constructor");
    } 
    
    @Override
    public String toString() {
        return "Plane " + getMark() + " " + getModel();
    }
}
