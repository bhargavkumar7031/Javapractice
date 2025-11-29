package org.example.services;

import org.springframework.stereotype.Component;

@Component
public interface NotificationService {
    void sendMessage(String message);
}
