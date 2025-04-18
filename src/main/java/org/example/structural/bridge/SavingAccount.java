package org.example.structural.bridge;

public class SavingAccount implements Account{
    @Override
    public void openAccount() {
        System.out.println("Opening Saving Account");
    }
}
