package org.kolokolov.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.kolokolov.oop.Car;
import org.kolokolov.oop.Vehicle;
import org.kolokolov.oop.enums.Carcase;

public class Comparison {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota", "Camry", Carcase.SEDAN));
        vehicles.add(new Car("Honda", "Jazz", Carcase.HATCHBACK));
        vehicles.add(new Car("Chevrolet", "Lacetti", Carcase.WAGON));
        
        vehicles.sort((a,b) -> a.getModel().compareTo(b.getModel()));
        
        System.out.println(vehicles);
        
        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(7);
        ints.add(12);
        ints.add(20);
        ints.add(5);
        
        ints.sort(null);
        
        System.out.println(ints);
        
        List<Double> doubles = new ArrayList<>();
        
        doubles.add(14.5);
        doubles.add(8D);
        doubles.add(17.4);
        
        doubles.stream().sorted().forEach(System.out::println);
        
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", Carcase.SEDAN));
        cars.add(new Car("Honda", "Jazz", Carcase.HATCHBACK));
        cars.add(new Car("Chevrolet", "Lacetti", Carcase.WAGON));
        
        cars.stream().sorted(Comparator.comparing(Car::getCarcase)).forEach(System.out::println);
        
    }
}
