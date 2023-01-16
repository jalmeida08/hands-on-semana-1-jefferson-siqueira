package com.eldorado.sistemafaturamento.faturamento;

import com.eldorado.sistemafaturamento.util.Util;

import java.util.ArrayList;
import java.util.List;

class FaturamentoBuilder {

    private String company;
    private int mes;
    private int ano;
    private List<Parcela> parcela = new ArrayList<>();

    public FaturamentoBuilder company(final String company) {
        this.company = company;
        return this;
    }

    public FaturamentoBuilder mes(final String mes) {
        if(mes == null)
            this.mes = 0;
        this.mes = Integer.valueOf(mes);
        return this;
    }

    public FaturamentoBuilder ano(final String ano){
        if(ano == null)
            this.ano = 0;
        this.ano = Integer.valueOf(ano);
        return this;
    }

    public FaturamentoBuilder listaParcela(String data, String valor) {
        if(parcela == null)
            return this;

        this.parcela.add(montaObjetoParcela(valor, data));
        return this;
    }
    public Faturamento build() {
        var f = new Faturamento();
        f.setCompany(this.company);
        f.setYear(this.ano);
        f.setMonth(this.mes);
        f.setParcela(this.parcela);
        return f;
    }


    private Parcela montaObjetoParcela(String valor, String data) {
        var p = new Parcela();
        p.setDate(Util.stringToDate(data));
        p.setAmount(Double.valueOf(valor.replace(",", ".")));
        return p;
    }

}
