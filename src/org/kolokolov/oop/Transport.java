package org.kolokolov.oop;

public abstract class Transport {
    
    private final String mark;
    private final String model;
    private int speed;
    
    public Transport(String mark, String model) {
        System.out.println("Transport abstract class constructor");
        this.mark = mark;
        this.model = model;
    }
    
    public void setSpeed(int speed) {
        System.out.println("Set " + speed + " km/h as the speed of " + this.mark + " " + this.model);
        this.speed = speed;
    }
    
    public int getSpeed() {
        return this.speed;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }
    
    @Override
    public String toString() {
        return "Transport " + getMark() + " " + getModel();
    } 
}
