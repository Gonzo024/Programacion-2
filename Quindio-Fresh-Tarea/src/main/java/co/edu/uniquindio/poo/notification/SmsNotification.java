package co.edu.uniquindio.poo.notification;
// package com.quindiofresh.notification;

public class SmsNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Enviando SMS: \"" + message + "\"");
    }
}
