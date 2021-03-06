package org.kolokolov.generics;

import java.util.ArrayList;
import java.util.List;

import org.kolokolov.oop.Car;
import org.kolokolov.oop.Transport;
import org.kolokolov.oop.enums.Carcase;
import org.kolokolov.oop.interfaces.Drivable;

public class Copier {
    public static <T extends Transport & Drivable> void copyList(List<T> src, List<? super T> out) {
        out.addAll(src);
    }
    
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", Carcase.SEDAN));
        cars.add(new Car("Skoda", "Octavia", Carcase.HATCHBACK));
        cars.add(new Car("BMW", "X5", Carcase.SUV));
//        cars.add(new Truck("MAN", "TGA", 18, TruckType.TRAKTOR));
        
        List<Car> transports = new ArrayList<>();
        
        copyList(cars, transports);
        
        transports.forEach(System.out::println);
    }
}
