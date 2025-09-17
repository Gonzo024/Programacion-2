package co.edu.uniquindio.poo.payment;
// package com.quindiofresh.payment;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Procesando pago de $" + amount + " con Tarjeta de Crédito.");
    }
}