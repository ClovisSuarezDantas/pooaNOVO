package org.example.interfaces.impls;

import org.example.interfaces.PaymentMethord;

import java.util.regex.Pattern;

public class PixPayment implements PaymentMethord {
    private final String pixKey;

    public PixPayment(String pixKey) {
        this.pixKey = pixKey;
    }

    @Override
    public boolean validate() {
        String emailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String cpfRegex = "\\d{11}";
        String phoneRegex = "\\d{10,11}";

        return Pattern.matches(emailRegex, pixKey) || Pattern.matches(cpfRegex, pixKey) || Pattern.matches(phoneRegex, pixKey);
    }

    @Override
    public void processPayment() {
        if (validate()) {
            System.out.println("Processing PIX Payment");
        } else {
            System.out.println("Invalid PIX key");
        }
    }
}
