package com.eldorado.sistemafaturamento.conformidade;

public class DadoNotaFaturamento {

    private String company;
    private int ano;
    private int mes;
    private double valorNota;
    private double valorTotalFaturamento;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }

    public double getValorTotalFaturamento() {
        return valorTotalFaturamento;
    }

    public void setValorTotalFaturamento(double valorTotalFaturamento) {
        this.valorTotalFaturamento = valorTotalFaturamento;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s", company, ano, mes, valorNota, valorTotalFaturamento);
    }
}
