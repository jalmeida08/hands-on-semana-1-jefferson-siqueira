package com.eldorado.sistemafaturamento.faturamento;

import java.time.LocalDate;

public class Parcela {

    private double amount;
    private LocalDate date;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;", amount, date);
    }
}
