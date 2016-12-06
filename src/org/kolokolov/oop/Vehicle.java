package org.kolokolov.oop;

import org.kolokolov.oop.interfaces.Drivable;

public abstract class Vehicle extends Transport implements Drivable {
    
    private final int wheelsNumber;

    public Vehicle(String mark, String model, int wheelsNumber) {
        super(mark, model);
        System.out.println("Vehicle abstract class constructor");
        this.wheelsNumber = wheelsNumber;
    }
    
    @Override
    public void drive() {
        int speed = getSpeed();
        if (speed > 0) {
            System.out.println(getMark() + " " + getModel() + " is driving with speed: " + speed + " km/h"); 
        } else {
            System.out.println(getMark() + " " + getModel() + " is standing");
        }
    }

    public int getWheelsNumber() {
        return wheelsNumber;
    }

    @Override
    public String toString() {
        return this.wheelsNumber + " vehicle " + getMark() + " " + getModel();
    } 
}
