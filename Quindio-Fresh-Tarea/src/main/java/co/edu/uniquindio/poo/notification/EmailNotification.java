package co.edu.uniquindio.poo.notification;
// package com.quindiofresh.notification;

import co.edu.uniquindio.poo.notification.NotificationService;

public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Enviando Email: \"" + message + "\"");
    }
}
