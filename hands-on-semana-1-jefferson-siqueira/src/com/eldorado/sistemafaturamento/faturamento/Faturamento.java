package com.eldorado.sistemafaturamento.faturamento;

import java.util.ArrayList;
import java.util.List;

public class Faturamento {

    private String company;
    private int month;
    private int year;
    private List<Parcela> parcela = new ArrayList<>();

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

    public List<Parcela> getParcela() {
        return parcela;
    }

    public void setParcela(List<Parcela> parcela) {
        this.parcela = parcela;
    }

    public double getTotalParcela() {
        return this.parcela.stream()
                .mapToDouble(Parcela::getAmount).sum();
    }

    public double getParcela(final int numParcela) {
        var size = this.parcela.size();
        if(numParcela > size)
            return 0;
        return this.parcela.get(numParcela).getAmount();
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;", company, year, month, parcela);
    }
}
