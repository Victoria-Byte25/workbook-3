package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class SearchInventory {
    public static void main(String[] args) {
        // Call getInventory method
        ArrayList<Product> inventory = getInventory();

        // Loop through and print each product
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    // Method to build the product list
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        try {
            File file = new File("src/main/resources/inventory.csv");
            Scanner scanner = new Scanner (file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    int id = Integer .parseInt(parts [0]);
                    String name = parts [1];
                    double price = Double.parseDouble(parts[2]);

                    Product product = new Product(id, name, price);
                    inventory.add(product);
                }

            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return inventory;

        }

    }

