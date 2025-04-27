package com.pluralsight;

public class Products {
    private int id;
    private String name;
    private double price;
    private String department;

    public Products(int id, String name, double price, String department) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    // Optional: you can also add other getters if you need them later

    @Override
    public String toString() {
        return id + " | " + name + " | $" + price + " | " + department;
    }
}
