package org.example.structural.facade;

public class ShippingService {

    public void freeShipping() {
        System.out.println("Free shipping");
    }

    public void standardShipping() {
        System.out.println("Standard shipping");
    }

    public void expressShipping() {
        System.out.println("Express shipping");
    }
}
