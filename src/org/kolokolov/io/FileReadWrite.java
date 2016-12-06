package org.kolokolov.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileReadWrite {
    public static void main(String[] args) {
        Customer[] customers = createCustomers();
        String fileName = "/home/kolokolov/java/EclipseProjects/TestField/out/customers.csv";
        writeCustomersToFile(customers, fileName);
        
        getFileInfo(fileName);
    }

    private static class Customer {
        private String firstName;
        private String lastName;
        private int age;
        
        public Customer(String firstName, String lastName, int age) {
            this.firstName =firstName;
            this.lastName = lastName;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "Customer " + this.firstName + " " + this.lastName + ", " + this.age;
        }
        
        public String getCustomerCsvInfo() {
            return this.firstName + "," + this.lastName + "," + this.age;
        }
    }
    
    public static Customer[] createCustomers() {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("John", "Smith", 21);
        customers[1] = new Customer("Bob", "Jackson", 30);
        customers[2] = new Customer("Karl", "Shkafic", 65);
        customers[3] = new Customer("Raggy", "Collins", 25);
        customers[4] = new Customer("Harry", "Davis", 45);
        
        return customers;
    }
    
    public static void writeCustomersToFile(Customer[] customers, String fileName) {
        File file = new File(fileName);
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))){
            Arrays.stream(customers).map((customer) -> customer.getCustomerCsvInfo()).forEach(writer::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(1);
        }
    }
    
    private static void getFileInfo(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("File " + file.getName() + " does not exist");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String str = reader.readLine();
            
            while (str != null) {
                System.out.println(str);
                String[] customerData = str.split(",");
                Customer customer = new Customer(customerData[0],customerData[1],Integer.parseInt(customerData[2]));
                System.out.println(customer);
                str = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }          
    }
}
