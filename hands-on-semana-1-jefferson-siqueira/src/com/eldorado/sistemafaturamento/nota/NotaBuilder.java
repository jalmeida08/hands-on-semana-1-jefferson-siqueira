package com.eldorado.sistemafaturamento.nota;

import com.eldorado.sistemafaturamento.util.Util;

import java.time.LocalDate;

class NotaBuilder {

    private String company;
    private int month;
    private int year;
    private double amount;
    private LocalDate dateEmission;
    private long note;

    public NotaBuilder company(final String company) {
        this.company = company;
        return this;
    }

    public NotaBuilder year(final String year) {
        this.year = Integer.valueOf(year);
        return this;
    }

    public NotaBuilder amount(final String amount) {
        this.amount = Double.valueOf(amount.replace(",", "."));
        return this;
    }

    public NotaBuilder month(final String month) {
        this.month = Integer.valueOf(month);
        return this;
    }

    public NotaBuilder dateEmission(final String dateEmission) {
        this.dateEmission = Util.stringToDate(dateEmission);
        return this;
    }

    public NotaBuilder note(final String note) {
        this.note = Long.valueOf(note);
        return this;
    }

    public Note build() {
        var n = new Note();
        n.setNote(this.note);
        n.setYear(this.year);
        n.setDateEmission(this.dateEmission);
        n.setCompany(this.company);
        n.setMonth(this.month);
        n.setAmount(this.amount);
        return n;
    }

}
