package co.edu.uniquindio.poo.shipping;
// package com.quindiofresh.shipping;

public class StandardShippingFactory implements ShippingFactory {
    @Override
    public ShippingCalculator createShippingCalculator() {
        return new StandardShipping();
    }
}