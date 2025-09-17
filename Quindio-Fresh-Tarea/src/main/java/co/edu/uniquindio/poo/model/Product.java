package co.edu.uniquindio.poo.model;
// package com.quindiofresh.model;

public class Product {
    private final String sku;
    private final String name;
    private double price;

    public Product(String sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
               "sku='" + sku + '\'' +
               ", name='" + name + '\'' +
               ", price=" + price +
               '}';
    }
}