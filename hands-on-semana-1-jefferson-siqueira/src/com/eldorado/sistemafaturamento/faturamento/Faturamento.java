package com.eldorado.sistemafaturamento.faturamento;

import java.util.ArrayList;
import java.util.List;

class Faturamento {

    private String company;
    private int mes;
    private int ano;
    private List<Parcela> parcela = new ArrayList<>();

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
