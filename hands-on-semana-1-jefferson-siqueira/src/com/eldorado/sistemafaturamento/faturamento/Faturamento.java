package com.eldorado.sistemafaturamento.faturamento;

import java.util.ArrayList;
import java.util.List;

public class Faturamento {

    private String company;
    private int mes;
    private int ano;
    private List<Parcela> parcela = new ArrayList<>();
    private Double totalParcela;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Parcela> getParcela() {
        return parcela;
    }

    public void setParcela(List<Parcela> parcela) {
        this.parcela = parcela;
    }

    public double getTotalParcela() {
        return this.parcela.stream()
                .mapToDouble(Parcela::getValorParcela).sum();
    }

    public double getParcela(final int numParcela) {
        var size = this.parcela.size();
        if(numParcela > size)
            return 0;
        return this.parcela.get(numParcela).getValorParcela();
    }

    @Override
    public String toString() {
        return "Faturamento{" +
                "company='" + company + '\'' +
                ", mes=" + mes +
                ", ano=" + ano +
                ", parcela=" + parcela +
                '}';
    }
}
