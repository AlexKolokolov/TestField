package org.kolokolov.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serializer {

    public static boolean persistEmployee(Employee employee, String dir) {
        boolean employeePersisted = false;
        boolean dirCreated = createDir(dir);
        if (dirCreated) {
            File file = new File(dir + "/employee_" + employee.getName());
            try (OutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(employee);
                employeePersisted = true;
                System.out.println(
                        "Employee was successfuly persisted to " + file.getAbsolutePath() + " file");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Can not persist enployee " + employee + ".\n Directory " + dir + " does not exist");
        }
        return employeePersisted;
    }

    public static Employee recoverEmployee(String name, String dir) {
        Employee recoveredEmployee = null;
        File file = new File(dir + "/employee_" + name);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object recoveredObject = ois.readObject();
                if (recoveredObject instanceof Employee) {
                    recoveredEmployee = (Employee) recoveredObject;
                }
                System.out.println("Employee was successfuly recovered from " + file.getAbsolutePath() + " file");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist");
        }
        return recoveredEmployee;
    }

    private static boolean createDir(String dir) {
        File directory = new File(dir);
        boolean dirCreated = false;
        if (!directory.exists()) {
            System.out.println("Creating directory " + directory.getAbsolutePath());
            dirCreated = directory.mkdirs();
            if (dirCreated) {
                System.out.println("Directory " + directory.getAbsolutePath() + " was seccessfuly created");
            } else {
                System.out.println("Directory " + dir + " creating failed");
            }
        } else {
            System.out.println("Directory " + directory.getAbsolutePath() + " has been already created");
            dirCreated = true;
        }
        return dirCreated;
    }
}
