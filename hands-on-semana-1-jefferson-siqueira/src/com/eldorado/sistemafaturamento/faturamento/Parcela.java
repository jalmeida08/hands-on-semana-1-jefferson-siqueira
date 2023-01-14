package com.eldorado.sistemafaturamento.faturamento;

import java.time.LocalDate;

class Parcela {

    private double valorParcela;
    private LocalDate dataParcela;

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public LocalDate getDataParcela() {
        return dataParcela;
    }

    public void setDataParcela(LocalDate dataParcela) {
        this.dataParcela = dataParcela;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "valorParcela=" + valorParcela +
                ", dataParcela=" + dataParcela +
                '}';
    }
}
