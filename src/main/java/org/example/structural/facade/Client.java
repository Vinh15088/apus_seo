package org.example.structural.facade;

public class Client {

    public static void main(String[] args) {

        Facade.getInstance().freeShippingByBank("vinhSeo@mgmail.com");
        Facade.getInstance().standardShippingByCard("vinhSeo@gmail.com", "0123456789");
    }
}
