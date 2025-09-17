package co.edu.uniquindio.poo.notification;
// package com.quindiofresh.notification;

public class EmailNotificationFactory implements NotificationFactory {
    @Override
    public NotificationService createNotificationService() {
        return new EmailNotification();
    }
}