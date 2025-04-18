package org.example.structural.facade;

public class SmsService {

    public void sendSms(String phoneNumber) {
        System.out.println("Sending SMS to " + phoneNumber);
    }
}
