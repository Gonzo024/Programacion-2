package co.edu.uniquindio.poo.model;
// package com.quindiofresh.model;

public class Customer {
    private final String name;
    private final String email;
    private final String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "name='" + name + '\'' + '}';
    }
}
