package com.eldorado.sistemafaturamento.nota;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Nota {
    private String company;
    private int mes;
    private int ano;
    private BigDecimal valor;
    private LocalDate dataEmissao;
    private long nota;

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public long getNota() {
        return nota;
    }

    public void setNota(long nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "company='" + company + '\'' +
                ", mes=" + mes +
                ", ano=" + ano +
                ", valor=" + valor +
                ", dataEmissao=" + dataEmissao +
                ", nota=" + nota +
                '}';
    }
}
