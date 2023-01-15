package com.eldorado.sistemafaturamento.nota;

import java.time.LocalDate;

public class Note {
    private String company;
    private int month;
    private int year;
    private double amount;
    private LocalDate dateEmission;
    private long note;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDate dateEmission) {
        this.dateEmission = dateEmission;
    }

    public long getNote() {
        return note;
    }

    public void setNote(long note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "company='" + company + '\'' +
                ", mes=" + month +
                ", ano=" + year +
                ", valor=" + amount +
                ", dataEmissao=" + dateEmission +
                ", nota=" + note +
                '}';
    }
}
