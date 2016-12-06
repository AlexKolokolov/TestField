package org.kolokolov.generics;

import java.util.ArrayList;
import java.util.List;

import org.kolokolov.oop.Car;
import org.kolokolov.oop.Plane;
import org.kolokolov.oop.Transport;
import org.kolokolov.oop.Truck;
import org.kolokolov.oop.Vehicle;
import org.kolokolov.oop.enums.Carcase;
import org.kolokolov.oop.enums.TruckType;

public class Demo {
    public static void main(String[] args) {
//         Next three lines are legal
        List<Transport> transportList = new ArrayList<>();
        transportList.add(new Car("Toyota", "Camry", Carcase.SEDAN));
        transportList.add(new Car("Skoda", "Octavia", Carcase.HATCHBACK));
        transportList.add(new Plane("Boeing", "777"));
        transportList.add(new Truck("MAN", "TGX", 18, TruckType.TRAKTOR));
        transportList.forEach((t) -> {
            if (t instanceof Vehicle) {
                Vehicle v = (Vehicle) t;
                System.out.println(v);
            }
            
        });
        
        List<Car> carList = new ArrayList<>();
        List<? extends Vehicle> veList = carList;
        carList.add(new Car("Toyota", "Camry", Carcase.SEDAN));
        carList.add(new Car("Skoda", "Octavia", Carcase.HATCHBACK));
        
        carList.forEach((v) -> {
          //Next line causes compile time error
            //Truck car = (Truck) v;
            Car car = (Car) v;
            
            System.out.println(car);
        });
        
        veList.forEach((v) -> {
            //Next line causes run time error
            //Truck car = (Truck) v;
            Car car = (Car) v;
            
            System.out.println(car);
        });
        
        List<? super Vehicle> superVehicleList = new ArrayList<>();
        superVehicleList.add(new Car("Toyota", "Camry", Carcase.SEDAN));
        superVehicleList.add(new Car("Skoda", "Octavia", Carcase.HATCHBACK));
        
        superVehicleList.forEach((sv) -> {
            Car vehicle = (Car) sv;
            
            System.out.println(vehicle);
        });
    }
}
