package com.pluralsight;

import java.util.ArrayList;

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

        inventory.add(new Product(27099, "Water", 19.99));
        inventory.add(new Product(10309, "Ramen", 9.99));
        inventory.add(new Product(23450, "Box of nails", 9.29));
        inventory.add(new Product(34562, "Dave's Food", 14.75));
        inventory.add(new Product(27898, "Laptop", 100.89));

        return inventory;
    }
}

