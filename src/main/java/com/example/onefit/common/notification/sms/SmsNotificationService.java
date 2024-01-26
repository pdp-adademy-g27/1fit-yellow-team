package com.example.onefit.common.notification.sms;

public interface SmsNotificationService {
    void sendNotification(String phoneNumber, String message);
}
