package com.eldorado.sistemafaturamento.faturamento;

import java.io.IOException;
import java.util.Map;

public class FaturamentoControl {
    private final FaturamentoFileManager faturamentoFileManager;
    public FaturamentoControl() {
        this.faturamentoFileManager = new FaturamentoFileManager();
    }

    public Map<Integer, Map<String, Double>> listFaturamentoForYearAndCompany() throws IOException {
        var lstFaturamento = faturamentoFileManager.readFaturamento();
        return new FaturamentoService().findListFaturamentoForYearAndCompany(lstFaturamento);
    }

    public Map<Integer, Map<String, Double[]>> companyGroupForYearAndSumParcelaForCompany() throws IOException {
        var lstFaturamento = faturamentoFileManager.readFaturamento();
        return new FaturamentoService().findCompanyGroupForYearAndSumParcelaForCompany(lstFaturamento);
    }

    public Map<Integer, Map<Integer, Map<String, Double>>> companyGroupForYearAndMonthAndSumParcela() throws IOException {
        var lstFaturamento = faturamentoFileManager.readFaturamento();
        return new FaturamentoService().findCompanyGroupForYearAndMonthAndSumParcela(lstFaturamento);
    }

    public void reportGenerateCompanyGroupForYearAndMonthAndSumParcela(Map<Integer, Map<Integer, Map<String, Double>>> list, final String fileName, final String heading) throws IOException {
        this.faturamentoFileManager.reportGenerateCompanyGroupForYearAndMonthAndSumParcela(list, fileName, heading);
    }

    public void reportGenerateCompanyGroupForYearAndSumParcelaForCompany(Map<Integer, Map<String, Double[]>> list, final String fileName, final String heading) throws IOException {
        this.faturamentoFileManager.reportGenerateCompanyGroupForYearAndSumParcelaForCompany(list,fileName, heading);
    }

    public void reportGenerateFaturamentoForYearAndCompany(Map<Integer, Map<String, Double>> listFaturamentoForYearAndCompany, String fileName, String heading) throws IOException {
        this.faturamentoFileManager.reportGenerateFaturamentoForYearAndCompany(listFaturamentoForYearAndCompany,fileName, heading);
    }
}
