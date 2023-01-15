package com.eldorado.sistemafaturamento.nota;

import com.eldorado.sistemafaturamento.util.Util;

import java.math.BigDecimal;
import java.time.LocalDate;

class NotaBuilder {

    private String company;
    private int mes;
    private int ano;
    private double valor;
    private LocalDate dataEmissao;
    private long nota;

    public NotaBuilder company(final String company) {
        this.company = company;
        return this;
    }

    public NotaBuilder ano(final String ano) {
        this.ano = Integer.valueOf(ano);
        return this;
    }

    public NotaBuilder valor(final String valor) {
        this.valor = Double.valueOf(valor.replace(",", "."));
        return this;
    }

    public NotaBuilder mes(final String mes) {
        this.mes = Integer.valueOf(mes);
        return this;
    }

    public NotaBuilder dataEmissao(final String dataEmissao) {
        this.dataEmissao = Util.stringToDate(dataEmissao);
        return this;
    }

    public NotaBuilder nota(final String nota) {
        this.nota = Long.valueOf(nota);
        return this;
    }

    public Nota build() {
        var n = new Nota();
        n.setNota(this.nota);
        n.setAno(this.ano);
        n.setDataEmissao(this.dataEmissao);
        n.setCompany(this.company);
        n.setMes(this.mes);
        n.setValor(this.valor);
        return n;
    }

}
