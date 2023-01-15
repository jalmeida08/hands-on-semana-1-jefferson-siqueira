package com.eldorado.sistemafaturamento.conformidade;

public class DadoNotaFaturamentoBuild {
    private String company;
    private int ano;
    private int mes;
    private double valorNota;
    private double valorTotalFaturamento;

    public DadoNotaFaturamentoBuild company(final String company) {
        this.company = company;
        return this;
    };
    public DadoNotaFaturamentoBuild ano(final int ano) {
        this.ano = ano;
        return this;
    };

    public DadoNotaFaturamentoBuild mes(final int mes) {
        this.mes = mes;
        return this;
    };

    public DadoNotaFaturamentoBuild valorNota(final double valorNota) {
        this.valorNota = valorNota;
        return this;
    };

    public DadoNotaFaturamentoBuild valorTotalFaturamento(final double valorTotalFaturamento) {
        this.valorTotalFaturamento = valorTotalFaturamento;
        return this;
    };

    public DadoNotaFaturamento build() {
        var dnf = new DadoNotaFaturamento();
        dnf.setCompany(this.company);
        dnf.setAno(this.ano);
        dnf.setMes(this.mes);
        dnf.setValorNota(this.valorNota);
        dnf.setValorTotalFaturamento(this.valorTotalFaturamento);
        return dnf;
    }
}
