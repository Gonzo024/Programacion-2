package co.edu.uniquindio.poo.shipping;
// package com.quindiofresh.shipping;

public class StandardShipping implements ShippingCalculator {
    private static final double COST = 7000.0; // [cite: 39]

    @Override
    public double calculateCost() {
        System.out.println("Calculando costo de envío Estándar: $" + COST);
        return COST;
    }
}
