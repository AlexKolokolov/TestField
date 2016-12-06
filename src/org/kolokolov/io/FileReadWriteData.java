package org.kolokolov.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWriteData {
    public static void main(String[] args) {
        Customer[] customers = createCustomers();
        String fileName = "/home/kolokolov/java/EclipseProjects/TestField/out/customers.dat";
        writeCustomersToFile(customers, fileName);

        getFileInfo(fileName);
    }

    private static class Customer {
        private String firstName;
        private String lastName;
        private int age;
        private boolean gender;
        private double balance;

        public Customer(String firstName, String lastName, int age, boolean gender, double balance) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Customer " + this.firstName + " " + this.lastName + ", " + this.age + ", " + (gender ? "M" : "F")
                    + ", balance: " + balance;
        }
    }

    public static Customer[] createCustomers() {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer("John", "Smith", 21, true, 15.50);
        customers[1] = new Customer("Bob", "Jackson", 30, true, 100.12);
        customers[2] = new Customer("Karla", "Shkafic", 65, false, 90.75);
        customers[3] = new Customer("Raggy", "Collins", 25, true, 17);
        customers[4] = new Customer("Harry", "Davis", 45, true, 50.01);

        return customers;
    }

    public static void writeCustomersToFile(Customer[] customers, String fileName) {
        File file = new File(fileName);
        try (DataOutputStream dataOutput = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (Customer c : customers) {
                dataOutput.writeUTF(c.firstName);
                dataOutput.writeUTF(c.lastName);
                dataOutput.writeInt(c.age);
                dataOutput.writeBoolean(c.gender);
                dataOutput.writeDouble(c.balance);
            }
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
        try (DataInputStream dataInput = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while(dataInput.available() > 0) {
                String firstName = dataInput.readUTF();
                String lastName = dataInput.readUTF();
                int age = dataInput.readInt();
                boolean gender = dataInput.readBoolean();
                double balance = dataInput.readDouble();
                Customer customer = new Customer(firstName, lastName, age, gender, balance);
                System.out.println(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
