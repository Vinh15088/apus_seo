package org.example.structural.bridge;

public class CheckingAccount implements Account {
    @Override
    public void openAccount() {
        System.out.println("Opening Checking Account");
    }
}
