package org.kolokolov.oop;

import org.kolokolov.oop.enums.AirTransportType;

public class Helicopter extends AirTransport {

    public Helicopter(String mark, String model) {
        super(mark, model, AirTransportType.HELICOPTER);
        System.out.println("Helicopter concrete class constructor");
    } 
    
    @Override
    public String toString() {
        return getType() + " " + getMark() + " " + getModel();
    }
}
