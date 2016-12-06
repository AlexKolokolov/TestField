package org.kolokolov.oop.patterns.decorator;

import org.kolokolov.oop.Car;

public class CarWithConditioning extends Car {
    
    private Car car;
    
    public CarWithConditioning(Car car) {
        super(car.getMark(), car.getModel(), car.getCarcase());
        this.car = car;
        System.out.println("Car with air conditioning concrete class constructor");
    }
    
    @Override
    public String toString() {
        return this.car.toString() + ", with air conditioning";
    }

}
