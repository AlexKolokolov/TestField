package org.kolokolov.oop;

import org.kolokolov.oop.enums.AirTransportType;
import org.kolokolov.oop.interfaces.Flying;

public abstract class AirTransport extends Transport implements Flying{
    private AirTransportType type;

    public AirTransport(String mark, String model, AirTransportType type) {
        super(mark, model);
        this.type = type;
        System.out.println("Air Transport abstract class constructor");
    }

    public AirTransportType getType() {
        return type;
    }
    
    @Override
    public void fly() {
        System.out.println(this.type + " " + getMark() + " " + getModel() + " is flying whith speed: " + getSpeed() + " km/h");
    }
}
