package com.pluralsight;

public class Employees {
    int employeeId;
    String name;
    double hoursWorked;
    double payRate;

    // Parameterized constructor
    public Employees(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    // Gross pay = hours worked * pay rate
    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}
