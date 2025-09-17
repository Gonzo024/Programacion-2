package co.edu.uniquindio.poo.payment;
// package com.quindiofresh.payment;

public class CreditCardPaymentFactory implements co.edu.uniquindio.poo.payment.PaymentFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
}
