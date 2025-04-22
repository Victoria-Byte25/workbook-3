package com.pluralsight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PayrollCalculator {
    public static void main(String[] args) {
        // Try to read the file
        try {
            // Load the file from the resources folder
            InputStream inputStream = PayrollCalculator.class.getResourceAsStream("/employees.csv");

            // Check if file was found
            if (inputStream == null) {
                System.out.println("File not found in resources folder.");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Skip the header row
            String header = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split line by |
                String[] tokens = line.split("\\|");

                // Get and convert each piece of data
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                // Create Employee object
                Employees employee = new Employees(id, name, hoursWorked, payRate);

                // Display info
                System.out.printf("ID: %d | Name: %-20s | Gross Pay: $%.2f\n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay());
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error converting number: " + e.getMessage());
        }
    }
}
