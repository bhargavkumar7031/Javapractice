package org.example.services;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements NotificationService{

    public void sendMessage(String message) {
        System.out.println("Sending " + message + " via email");
    }
}
