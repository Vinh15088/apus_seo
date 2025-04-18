package org.example.structural.facade;

public class PaymentService {

    public void paymentByCash() {
        System.out.println("Payment by cash");
    }

    public void paymentByCreditCard() {
        System.out.println("Payment by credit card");
    }

    public void paymentByBank() {
        System.out.println("Payment by bank");
    }
}
