package org.kolokolov.oop;

import java.util.Arrays;
import java.util.Random;

import org.kolokolov.oop.enums.Carcase;
import org.kolokolov.oop.enums.TruckType;
import org.kolokolov.oop.enums.VehicleType;
import org.kolokolov.oop.interfaces.Drivable;
import org.kolokolov.oop.interfaces.FireFiter;
import org.kolokolov.oop.patterns.decorator.CarWithConditioning;
import org.kolokolov.oop.patterns.factory.TransportFactory;
import org.kolokolov.oop.patterns.factory.VehicleFactory;

public class DemoMain {
    public static void main(String[] args) {
        Car toyotaCamry = new Car("Toyota", "Camry", Carcase.SEDAN);
        Vehicle someCar = toyotaCamry;
        Transport someVehicle = someCar;
        Drivable drivableTransport = someCar;
        
        System.out.println("Car: " + toyotaCamry);
        System.out.println("Vehicle: " + someCar);
        System.out.println("Transport: " + someVehicle);
        System.out.println("Drivable: " + drivableTransport);
   
        toyotaCamry.setSpeed(70);
        toyotaCamry.drive();
        
        System.out.println("==============================");
        
        Truck manTgx = new Truck("MAN", "TGX", 18, TruckType.TRAKTOR);
        Vehicle someTruck = manTgx;
        someVehicle = someTruck;
        drivableTransport = someTruck;
        
        System.out.println("Truck: " + manTgx);
        System.out.println("Vehicle: " + someTruck);
        System.out.println("Transport: " + someVehicle);
        System.out.println("Drivable: " + drivableTransport);
        
        manTgx.setSpeed(50);
        manTgx.drive();
        
        System.out.println("==============================");
        
        Car bmwX6 = new Car("BMW", "X6", Carcase.SUV);
        System.out.println(bmwX6);
        bmwX6.setSpeed(60);
        
        Car bmwX6C = new CarWithConditioning(bmwX6);
        System.out.println(bmwX6C);
        bmwX6C.setSpeed(70);
        
        bmwX6.drive();
        bmwX6C.drive();
        
        System.out.println("==============================");
        
        FireTruck manTgmHlf20 = new FireTruck("MAN", "TGM HLF 20", 4);
        Truck someFireFiter = manTgmHlf20;
        someTruck = someFireFiter;
        someVehicle = someTruck;
        drivableTransport = someTruck;
        FireFiter fireFighter = manTgmHlf20;
        
        System.out.println("Truck: " + manTgmHlf20);
        System.out.println("Vehicle: " + someTruck);
        System.out.println("Transport: " + someVehicle);
        System.out.println("Drivable: " + drivableTransport);
        System.out.println("Fire fighter: " + fireFighter);
        
        manTgmHlf20.setSpeed(90);
        someTruck.setSpeed(100);
        
        someTruck.drive();
        
        manTgmHlf20.extinguishFire();
        fireFighter.extinguishFire();
        
        System.out.println("==============================");
        
        FireHelicopter sikorskyS70cFirehawk = new FireHelicopter("Sikorsky", "S-70C Firehawk");
        Helicopter fireHelicopter = sikorskyS70cFirehawk;
        AirTransport someHelicopter = fireHelicopter;
        Transport someAirTransport = someHelicopter;
        fireFighter = sikorskyS70cFirehawk;
        
        System.out.println("Helicopter: " + sikorskyS70cFirehawk);
        System.out.println("Air transport: " + someHelicopter);
        System.out.println("Transport: " + someAirTransport);
        System.out.println("Flying: " + someAirTransport);
        System.out.println("Fire fighter: " + sikorskyS70cFirehawk);
        
        sikorskyS70cFirehawk.setSpeed(300);
        sikorskyS70cFirehawk.fly();
        sikorskyS70cFirehawk.extinguishFire();
        fireFighter.extinguishFire();
        
        System.out.println("==============================");
        
        TransportFactory<Vehicle> transportFactory = new VehicleFactory();
        transportFactory.setVehicleType(VehicleType.CAR);
        transportFactory.setVehicleMark("ZAZ");
        transportFactory.setVehicleModel("Lanos");
        transportFactory.setCarcase(Carcase.SEDAN);
        Vehicle vehicle = transportFactory.createTransport();
        System.out.println(vehicle);
        vehicle.setSpeed(80);
        vehicle.drive();
        
        System.out.println("==============================");
        
        transportFactory.setVehicleType(VehicleType.TRUCK);
        transportFactory.setVehicleMark("KRAZ");
        transportFactory.setVehicleModel("Spartan");
        transportFactory.setTruckType(TruckType.SPECIAL);
        transportFactory.setVehicleWheelsNumber(4);
        vehicle = transportFactory.createTransport();
        System.out.println(vehicle);
        vehicle.drive();
        
        System.out.println("==============================");
        
        Vehicle[] krazes = new Vehicle[6];
        Random rnd = new Random();
        
        for (int i = 0; i < krazes.length; i++) {
            System.out.println("++++++++++++++++++++++");
            krazes[i] = transportFactory.createTransport();
        }
        
        Arrays.stream(krazes).forEach((kraz) -> {
            System.out.println("-------------------");
            kraz.setSpeed(rnd.nextInt(70) + 30);
            kraz.drive();
        });
        
        for (Vehicle kraz : krazes) {
            System.out.println(kraz);
        }
        
        
    }
}
