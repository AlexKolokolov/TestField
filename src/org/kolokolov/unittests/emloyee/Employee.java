package org.kolokolov.unittests.emloyee;

public class Employee {
    private String name;
    private int feePerMonth;
    private int monthesAtWork;
    
    public Employee(String name, int feePerMonth, int monthesAtWork) {
        this.name = name;
        this.feePerMonth = feePerMonth;
        this.monthesAtWork = monthesAtWork;
    }
    
    public int countFeePerYear() {
        return feePerMonth * 12;
    }
    
    public double countYearBonus() {
        int feePerYear = countFeePerYear();
        return 0.01 * feePerYear * monthesAtWork; 
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", feePerMonth=" + feePerMonth + ", monthesAtWork=" + monthesAtWork + "]";
    } 
}
