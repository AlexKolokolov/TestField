package org.kolokolov.xml.model;

public class Person {
    private int id;
    private String name;
    private int age;
    private Address address;
    
    public Person() {}
    
    public Person(int id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("Person, id: %04d%n Name: %s%n Age: %d%n %s", id, name, age, address.toString());
    }
    
    public static void main(String[] args) {
        System.out.println(new Person(13 , "Alex", 31, new Address("Chumatskaya", 8)));
    }
}
