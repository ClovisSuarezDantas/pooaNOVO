package org.example.interfaces.impls;

import org.example.interfaces.PaymentMethord;

import java.time.LocalDate;

public class BoletoPayment implements PaymentMethord {
    private final LocalDate dueDate;

    public BoletoPayment(String boletoNumber, LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean validate() {
        return !LocalDate.now().isAfter(dueDate);
    }

    @Override
    public void processPayment() {
        if (validate()) {
            System.out.println("Processing Boleto Payment");
        } else {
            System.out.println("Boleto is expired");
        }
    }
}