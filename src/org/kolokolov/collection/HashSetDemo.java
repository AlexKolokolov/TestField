package org.kolokolov.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Employee> staff = new HashSet<>(4);
        
        Employee alex = new Employee(1, "Alex");
        Employee bob = new Employee(2, "Bob");
        Employee harry = new Employee(3, "Harry");
        
        staff.add(alex);
        staff.add(bob);
        staff.add(harry);
        
        staff.forEach(System.out::println);
        System.out.println("===========================");
        
        alex.setId(50);

        staff.forEach(System.out::println);
        
        System.out.println(staff.contains(alex));
        
        staff.add(new Employee(50, "Alex"));
        staff.add(new Employee(50, "Alex"));
        System.out.println("===========================");
        staff.forEach(System.out::println);
//        System.out.println("===========================");
//        staff.add(new Employee(10, "NoName"));
//        staff.add(new Employee(11, "NoName"));
//        staff.add(new Employee(12, "NoName"));
//        staff.add(new Employee(13, "NoName"));
//        staff.add(new Employee(14, "NoName"));
//        staff.add(new Employee(15, "NoName"));
//        staff.add(new Employee(20, "NoName"));
//        staff.add(new Employee(21, "NoName"));
//        staff.add(new Employee(22, "NoName"));
//        staff.add(new Employee(23, "NoName"));
//        staff.add(new Employee(24, "NoName"));
//        staff.add(new Employee(25, "NoName"));
//        
//        staff.forEach(System.out::println);
    }

}

class Employee {
    private int id;
    private String name;
    private int hash;
    
    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        this.hash = result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "#=" + hash + "]";
    }    
}
