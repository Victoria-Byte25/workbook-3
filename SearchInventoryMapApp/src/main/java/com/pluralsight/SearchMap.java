package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchMap {
    public static void main(String[] args) {
        Map<String, Products> inventory = loadInventory();
        Scanner scanner = new Scanner(System.in);

        boolean continueSearch = true;

        while (continueSearch) {
            System.out.print("\nEnter product name to search: ");
            String searchName = scanner.nextLine();

            Products found = inventory.get(searchName);

            if (found != null) {
                System.out.println("Product found: " + found);
            } else {
                System.out.println("Product not found.");
            }

            System.out.print("Do you want to search again? (yes/no): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                continueSearch = false;
                System.out.println("Goodbye!");
            }
        }
    }

    public static Map<String, Products> loadInventory() {
        Map<String, Products> inventory = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Inventory.csv"))) {
            String line;
            reader.readLine(); // Skip header if there is one

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // split by the pipe symbol |

                if (parts.length < 4) {
                    continue;
                }

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                String department = parts[3].trim();

                Products product = new Products(id, name, price, department);
                inventory.put(name, product);
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }

        return inventory;
    }
}
