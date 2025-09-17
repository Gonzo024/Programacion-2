package co.edu.uniquindio.poo.payment;
// package com.quindiofresh.payment;

public class PsePayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Procesando pago de $" + amount + " con PSE.");
    }
}
