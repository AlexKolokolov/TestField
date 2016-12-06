package org.kolokolov.oop;

import org.kolokolov.oop.interfaces.FireFiter;

public class FireHelicopter extends Helicopter implements FireFiter {

    public FireHelicopter(String mark, String model) {
        super(mark, model);
        System.out.println("Fire helicopter concrete class constructor");
    }
    
    @Override
    public void extinguishFire() {
        System.out.println(getMark() + " " + getModel() + " is extinguishing the fire from air");
    }
}
