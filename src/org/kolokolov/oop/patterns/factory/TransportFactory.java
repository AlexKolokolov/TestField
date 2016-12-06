package org.kolokolov.oop.patterns.factory;

import org.kolokolov.oop.Transport;
import org.kolokolov.oop.enums.Carcase;
import org.kolokolov.oop.enums.TruckType;
import org.kolokolov.oop.enums.VehicleType;

public abstract class TransportFactory<T extends Transport> {
    
    private String vehicleMark = "Unspecified";
    private String vehicleModel = "Unspecified";
    private VehicleType vehicleType;
    private Carcase carcase = Carcase.UNSPECIFIED;
    private TruckType truckType = TruckType.UNSPECIFIED;
    private int vehicleWheelsNumber;
    
    public abstract T createTransport();

    public String getVehicleMark() {
        return vehicleMark;
    }

    public void setVehicleMark(String vehicleMark) {
        this.vehicleMark = vehicleMark;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Carcase getCarcase() {
        return carcase;
    }

    public void setCarcase(Carcase carcase) {
        this.carcase = carcase;
    }

    public TruckType getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckType truckType) {
        this.truckType = truckType;
    }

    public int getVehicleWheelsNumber() {
        return vehicleWheelsNumber;
    }

    public void setVehicleWheelsNumber(int vehicleWheelsNumber) {
        this.vehicleWheelsNumber = vehicleWheelsNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
