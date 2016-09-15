package org.kolokolov.unittests.emloyee;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest1 {
    
    private Employee employee;
    

    @BeforeClass
    public static void init() {
        System.out.println("Alex test begin");
    }
    
    @AfterClass
    public static void finish() {
        System.out.println("Alex test completed");
    }
    
    @Before
    public void createEmployee() {
        employee = new Employee("Alex", 5000, 96);
    }
    
    @Test
    public void TestYearFeeCounter() {
        Assert.assertEquals(60000, employee.countFeePerYear());
    }
    
    @Test
    public void TestYearBonusCounter() {
        Assert.assertEquals(57600, employee.countYearBonus(), 0.0);
    }
}
