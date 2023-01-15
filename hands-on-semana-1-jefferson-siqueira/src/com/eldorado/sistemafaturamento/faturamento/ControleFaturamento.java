package com.eldorado.sistemafaturamento.faturamento;

import java.io.IOException;
import java.util.Map;

public class ControleFaturamento {

    public Map<Integer, Map<String, Double>> listFaturamentoForYearAndCompany() throws IOException {
        var lstFaturamento = new FileManagerFaturamento().readFaturamento();
        return new ServiceFaturamento().findListFaturamentoForYearAndCompany(lstFaturamento);
    }

    public Map<Integer, Map<String, Double[]>> companyGroupForYearAndSumParcelaForCompany() throws IOException {
        var lstFaturamento = new FileManagerFaturamento().readFaturamento();
        return new ServiceFaturamento().findCompanyGroupForYearAndSumParcelaForCompany(lstFaturamento);
    }

    public Map<Integer, Map<Integer, Map<String, Double>>> companyGroupForYearAndMonthAndSumParcela() throws IOException {
        var lstFaturamento = new FileManagerFaturamento().readFaturamento();
        return new ServiceFaturamento().findCompanyGroupForYearAndMonthAndSumParcela(lstFaturamento);
    }
}
