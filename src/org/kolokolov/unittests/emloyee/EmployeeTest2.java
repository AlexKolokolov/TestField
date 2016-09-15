package org.kolokolov.unittests.emloyee;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest2 {
   private Employee employee;
   
   @BeforeClass
   public static void init() {
       System.out.println("Oleg test begin");
   }
   
   @AfterClass
   public static void finish() {
       System.out.println("Oleg test completed");
   }
   
   @Before
   public void craeteEmployee() {
       employee = new Employee("Oleg", 4000, 6);
   }
   
   @Test
   public void testFeePerYearCounter() {
       Assert.assertEquals(48000, employee.countFeePerYear());
   }
   
   @Test
   public void testYearBonusCounter() {
       Assert.assertEquals(2880, employee.countYearBonus(), 0.0);
   }
}
