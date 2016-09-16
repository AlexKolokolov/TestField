package org.kolokolov.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name;
    private int yearOfBirth;
    private String position;
   
    public Employee(String name, int yearOfBirth, String position) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.position = position;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee [" + name + ", " + yearOfBirth + " year of birth, position: " + position + "]";
    }
}
