package org.kolokolov.collection;

import java.util.HashMap;
import java.util.Map;

import org.kolokolov.oop.Car;
import org.kolokolov.oop.Plane;
import org.kolokolov.oop.Transport;
import org.kolokolov.oop.Truck;
import org.kolokolov.oop.enums.Carcase;
import org.kolokolov.oop.enums.TruckType;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Transport> transports = new HashMap<>();
        
        transports.put("camry", new Car("Toyota", "Camry", Carcase.SEDAN));
        transports.put("boeing", new Plane("Boeing", "777"));
        transports.put("man", new Truck("MAN", "TRG", 18, TruckType.TRAKTOR));
        
        System.out.println(transports);
        
        transports.forEach((k,v) -> System.out.println(k + " : " + v));
        transports.entrySet().forEach(System.out::println);
        
        for (Map.Entry<String,Transport> entry : transports.entrySet()) {
            System.out.println(entry);
        }
    }
}
