package org.kolokolov.oop;

import org.kolokolov.oop.enums.TruckType;

public class Truck extends Vehicle {
    
    private TruckType truckType;

    public Truck(String mark, String model, int wheelsNumber, TruckType truckType) {
        super(mark, model, wheelsNumber);
        this.truckType = truckType;
        System.out.println("Truck concrete class constructor");
    }
    
    @Override
    public String toString() {
        return  getWheelsNumber() + " wheels truck " + getMark() + " " + getModel() + " type: " + this.truckType;
    } 
}
