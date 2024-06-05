package org.example.interfaces.impls;

import org.example.interfaces.PaymentMethord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardPayment implements PaymentMethord {
    private final String cardNumber;
    private final String expiryDate;

    public CardPayment(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean validate() {
        if (!cardNumber.matches("\\d{16}")) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        LocalDate expiry = LocalDate.parse("01/" + expiryDate, formatter);

        return !LocalDate.now().isAfter(expiry);
    }

    @Override
    public void processPayment() {
        if (validate()) {
            System.out.println("Processing Card Payment");
        } else {
            System.out.println("Invalid Card details");
        }
    }
}