package com.eldorado.sistemafaturamento;

import com.eldorado.sistemafaturamento.conformidade.ConformidadeControl;
import com.eldorado.sistemafaturamento.faturamento.ControleFaturamento;
import com.eldorado.sistemafaturamento.nota.ControleNota;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var cf = new ControleFaturamento();
        var listFaturamentoForYearAndCompany = cf.listFaturamentoForYearAndCompany();
        var listCompanyGroupForYearAndSumParcelaForCompany = cf.companyGroupForYearAndSumParcelaForCompany();
        var listCompanyGroupForYearAndMonthAndSumParcela = cf.companyGroupForYearAndMonthAndSumParcela();

        var cn = new ControleNota();
        var listaNota = cn.iniciaLeituraDeNota();

        var conformidadeControl = new ConformidadeControl();

        conformidadeControl.generateReportWithConformidade(listCompanyGroupForYearAndMonthAndSumParcela, listaNota);
    }
}