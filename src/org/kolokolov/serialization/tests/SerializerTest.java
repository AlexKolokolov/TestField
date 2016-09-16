package org.kolokolov.serialization.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kolokolov.serialization.Employee;
import org.kolokolov.serialization.Serializer;

@RunWith(Parameterized.class)
public class SerializerTest {
    
    private Employee testEmployee;
    private String testDirectory;
    private String expectedResult;
    
    public SerializerTest(Employee testEmployee, String testDirectory, String expectedResult) {
        this.testEmployee = testEmployee;
        this.testDirectory = testDirectory;
        this.expectedResult = expectedResult;
    }

    @BeforeClass
    public static void createTestSerializer() {
        System.out.println("Employee serializer tests started");
    }
    
    @AfterClass
    public static void afterTests() {
        System.out.println("Employee serializer tests comleted");
    }
    
    @Parameters
    public static Collection<Object[]> emloyees() {
        return Arrays.asList(new Object[][] {
            {new Employee("Alex", 1985, "junior"), "testfield1", "Employee [Alex, 1985 year of birth, position: junior]"},
            {new Employee("Dmitri", 1985, "senior"), "testfield1", "Employee [Dmitri, 1985 year of birth, position: senior]"},
            {new Employee("Sergey", 1971, "team lead"), "testfield2", "Employee [Sergey, 1971 year of birth, position: team lead]"},
        });
    }
    
    @Test
    public void testEmployeeSerialization() {
        Assert.assertTrue(Serializer.persistEmployee(testEmployee, testDirectory));
    }
    
    @Test
    public void testEmployeeSerializationAndRecovery() {
        Serializer.persistEmployee(testEmployee, testDirectory);
        Employee recoveredEmployee = Serializer.recoverEmployee(testEmployee.getName(), testDirectory);
        Assert.assertEquals(expectedResult, recoveredEmployee.toString());
    }
}





