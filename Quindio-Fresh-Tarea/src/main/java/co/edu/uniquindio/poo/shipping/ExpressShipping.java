package co.edu.uniquindio.poo.shipping;
// package com.quindiofresh.shipping;

public class ExpressShipping implements ShippingCalculator {
    private static final double COST = 15000.0; // [cite: 40]

    @Override
    public double calculateCost() {
        System.out.println("Calculando costo de envío Express: $" + COST);
        return COST;
    }
}