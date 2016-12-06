package org.kolokolov.oop;

import org.kolokolov.oop.enums.Carcase;

public class Car extends Vehicle {
    
    private final Carcase carcase;

    public Car(String mark, String model, Carcase carcase) {
        super(mark, model, 4);
        this.carcase = carcase; 
        System.out.println("Car concrete class constructor");
    }

    public Carcase getCarcase() {
        return carcase;
    }

    @Override
    public String toString() {
        return "4 wheels car " + getMark() + " " + getModel() + " carcase: " + this.carcase;
    }   
}
