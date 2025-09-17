package co.edu.uniquindio.poo.notification;
// package com.quindiofresh.notification;

public class SmsNotificationFactory implements NotificationFactory {
    @Override
    public NotificationService createNotificationService() {
        return new SmsNotification();
    }
}