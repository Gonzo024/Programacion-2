package co.edu.uniquindio.poo.payment;
// package com.quindiofresh.payment;

public class PsePaymentFactory implements PaymentFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new PsePayment();
    }
}