package com.pluralsight;

public class Product {
    private String productName;
    private double price;
    private int productID;

    // Constructor
    public Product(int productID, String productName, double price) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }

    // Getters
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    // Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    // Display method
    @Override
    public String toString() {
        return "ID: " + productID + ", Name: " + productName + ", Price: $" + price;
    }
}








