package org.example.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements NotificationService {
    public void sendMessage(String Message) {
        System.out.println(Message + " sent via SMS");
    }
}
