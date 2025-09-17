package co.edu.uniquindio.poo.shipping;
// package com.quindiofresh.shipping;

public class ExpressShippingFactory implements ShippingFactory {
    @Override
    public ShippingCalculator createShippingCalculator() {
        return new ExpressShipping();
    }
}