package org.example.structural.bridge;

public class TPBank extends Bank {

    public TPBank(Account account) {
        super(account);
    }

    @Override
    public void openAccount() {
        System.out.println("Opening an account at TPBank");
        account.openAccount();
    }
}
