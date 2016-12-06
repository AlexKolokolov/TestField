package org.kolokolov.oop.patterns.factory;

import org.kolokolov.oop.Car;
import org.kolokolov.oop.Truck;
import org.kolokolov.oop.Vehicle;
import org.kolokolov.oop.enums.VehicleType;

public class VehicleFactory extends TransportFactory<Vehicle>{
    
    @Override
    public Vehicle createTransport() {
        if (getVehicleType().equals(VehicleType.CAR)) {
            return new Car(getVehicleMark(), getVehicleModel(), getCarcase());
        }
        if (getVehicleType().equals(VehicleType.TRUCK)) {
            return new Truck(getVehicleMark(), getVehicleModel(), getVehicleWheelsNumber(), getTruckType());
        }
        return null;
    }
}
