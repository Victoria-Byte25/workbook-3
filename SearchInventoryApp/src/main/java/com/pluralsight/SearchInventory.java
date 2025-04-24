package com.pluralsight;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner input = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1 - List all products");
            System.out.println("2 - Lookup a product by its ID");
            System.out.println("3 - Find all products within a price range");
            System.out.println("4 - Add a new product");
            System.out.println("5 - Quit the application");
            System.out.print("Enter command: ");
            int choice = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    for (Product p : inventory) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int idSearch = input.nextInt();
                    input.nextLine();
                    boolean found = false;
                    for (Product p : inventory) {
                        if (p.getProductID() == idSearch) {
                            System.out.println("Found: " + p);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter minimum price: ");
                    double min = input.nextDouble();
                    System.out.print("Enter maximum price: ");
                    double max = input.nextDouble();
                    input.nextLine();
                    for (Product p : inventory) {
                        if (p.getPrice() >= min && p.getPrice() <= max) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter new product ID: ");
                    int newID = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter product name: ");
                    String newName = input.nextLine();
                    System.out.print("Enter product price: ");
                    double newPrice = input.nextDouble();
                    input.nextLine();

                    Product newProduct = new Product(newID, newName, newPrice);
                    inventory.add(newProduct);
                    System.out.println("✅ Product added!");
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        try {
            File file = new File("src/main/resources/inventory.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);

                    Product product = new Product(id, name, price);
                    inventory.add(product);
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }

        return inventory;
    }
}
