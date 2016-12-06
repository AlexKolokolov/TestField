package org.kolokolov.oop;

import org.kolokolov.oop.enums.TruckType;
import org.kolokolov.oop.interfaces.FireFiter;

public class FireTruck extends Truck implements FireFiter{

    public FireTruck(String mark, String model, int wheelsNumber) {
        super(mark, model, wheelsNumber, TruckType.SPECIAL);
        System.out.println("FireTruck concrete class constructor");
    }
    
    @Override
    public void extinguishFire() {
        System.out.println(getMark() + " " + getModel() + " is extinguishing the fire from surface");
    }
}
