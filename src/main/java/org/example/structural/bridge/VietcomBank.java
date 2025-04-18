package org.example.structural.bridge;

public class VietcomBank extends Bank {

    public VietcomBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.println("Opening an account at VietcomBank");
        account.openAccount();
    }
}
