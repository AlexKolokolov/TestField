package org.kolokolov.unittests.emloyee;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParametrizedEmployeeTest {
    Employee employee;
    int expectedFeePerYear;
    double expectedYearBonus;
    
    public ParametrizedEmployeeTest(Employee employee, int expectedFeePerYear, double expectedYearBonus) {
        this.employee = employee;
        this.expectedFeePerYear = expectedFeePerYear;
        this.expectedYearBonus = expectedYearBonus;
    }
    
    @BeforeClass
    public static void init() {
        System.out.println("Parametrized test begin");
    }
    
    @AfterClass
    public static void finish() {
        System.out.println("Parametrized test completed");
    }
    
    @Parameters
    public static Collection<Object[]> emloyees() {
        return Arrays.asList(new Object[][] {
            {new Employee("Sergey", 4500, 60), 54000, 32400},
            {new Employee("Denis", 3500, 24), 42000, 10080}
        });
    }
    
    @Test
    public void TestYearFeeCounter() {
        Assert.assertEquals(expectedFeePerYear, employee.countFeePerYear());
    }
    
    @Test
    public void TestYearBonusCounter() {
        Assert.assertEquals(expectedYearBonus, employee.countYearBonus(), 0.0);
    }
    
}
