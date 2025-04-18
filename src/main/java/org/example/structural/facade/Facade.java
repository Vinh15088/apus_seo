package org.example.structural.facade;

import lombok.Getter;

public class Facade {

    @Getter
    private static final Facade instance = new Facade();

    private final AccountService accountService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final EmailService emailService;
    private final SmsService smsService;

    private Facade() {
        accountService = new AccountService();
        paymentService = new PaymentService();
        shippingService = new ShippingService();
        emailService = new EmailService();
        smsService = new SmsService();
    }

    public void freeShippingByBank(String email) {
        accountService.getAccount(email);
        paymentService.paymentByBank();
        shippingService.freeShipping();
        emailService.senEmail(email);

        System.out.println("Done");
    }

    public void standardShippingByCard(String email, String phoneNumber) {
        accountService.getAccount(email);
        paymentService.paymentByCreditCard();
        shippingService.standardShipping();
        emailService.senEmail(email);
        smsService.sendSms(phoneNumber);

        System.out.println("Done");
    }
}
