package com.eldorado.sistemafaturamento.faturamento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.Collectors;

class FaturamentoService {

    Map<Integer, Map<String, Double>> findListFaturamentoForYearAndCompany(List<Faturamento> listaFaturamento) {
        return this.companyGroupForYearAndSumParcela(listaFaturamento);
    }

    Map<Integer, Map<String, Double[]>>  findCompanyGroupForYearAndSumParcelaForCompany(List<Faturamento> listaFaturamento) {
        return this.companyGroupForYearAndSumParcelaForCompany(listaFaturamento);
    }

    Map<Integer, Map<Integer, Map<String, Double>>> findCompanyGroupForYearAndMonthAndSumParcela(List<Faturamento> listaFaturamento) {
        return this.companyGroupForYearAndMonthAndSumParcela(listaFaturamento);
    }



    private Map<Integer, Map<String, Double>> companyGroupForYearAndSumParcela(List<Faturamento> listaFaturamento) {
        return listaFaturamento
                .stream()
                .collect(
                        Collectors.groupingBy(
                                        Faturamento::getYear, Collectors.groupingBy(
                                                Faturamento::getCompany, Collectors.summingDouble(Faturamento::getTotalParcela))
                        )
                );
    }

    private Map<Integer, Map<Integer, Map<String, Double>>> companyGroupForYearAndMonthAndSumParcela(List<Faturamento> listaFaturamento) {
        return listaFaturamento
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Faturamento::getYear, Collectors.groupingBy(
                                        Faturamento::getMonth, Collectors.groupingBy(
                                            Faturamento::getCompany, Collectors.summingDouble(Faturamento::getTotalParcela))
                                        )
                        )
                );
    }
    private Map<Integer, Map<String, Double[]>> companyGroupForYearAndSumParcelaForCompany(List<Faturamento> listaFaturamento) {
        Map<Integer, Map<String, Double[]>> listCompanyGroupForYearAndSumParcelaForCompany = new HashMap<>();

        faturamentoAgroupForYears(listaFaturamento, listCompanyGroupForYearAndSumParcelaForCompany);
        companyAgroupForYears(listaFaturamento, listCompanyGroupForYearAndSumParcelaForCompany);

        GroupForYearAndSumParcelaForCompany(listaFaturamento, listCompanyGroupForYearAndSumParcelaForCompany);
        return listCompanyGroupForYearAndSumParcelaForCompany;
    }

    private void faturamentoAgroupForYears(List<Faturamento> listaFaturamento, Map<Integer, Map<String, Double[]>> listCompanyGroupForYearAndSumParcelaForCompany) {
        listaFaturamento.stream().parallel().forEach(f -> {
            listCompanyGroupForYearAndSumParcelaForCompany.putIfAbsent(f.getYear(), new HashMap<String, Double[]>());
        });
    }
    private void companyAgroupForYears(List<Faturamento> listaFaturamento, Map<Integer, Map<String, Double[]>> listCompanyGroupForYearAndSumParcelaForCompany) {
        listaFaturamento.stream().parallel().forEach(f -> {
            Double[] arrayParcela = new Double[3];
            arrayParcela[0] = Double.valueOf(0);
            arrayParcela[1] = Double.valueOf(0);
            arrayParcela[2] = Double.valueOf(0);
            listCompanyGroupForYearAndSumParcelaForCompany.get(f.getYear()).putIfAbsent(f.getCompany(), arrayParcela);
        });
    }
    private void GroupForYearAndSumParcelaForCompany(List<Faturamento> listaFaturamento, Map<Integer, Map<String, Double[]>> listCompanyGroupForYearAndSumParcelaForCompany) {
        listaFaturamento.stream().forEach(f -> {
            var arrayParcela = listCompanyGroupForYearAndSumParcelaForCompany.get(f.getYear()).get(f.getCompany());
            arrayParcela[0] = CalculaParcela(arrayParcela, f, 0);
            arrayParcela[1] = CalculaParcela(arrayParcela, f, 1);
            arrayParcela[2] = CalculaParcela(arrayParcela, f, 2);
        });
    }


    private Double CalculaParcela(Double[] arrayParcela, Faturamento f, int arrayIndex) {
        DoubleAdder doubleAdderParcela = new DoubleAdder();
        var parcela = arrayParcela[arrayIndex];
        doubleAdderParcela.add(parcela);
        doubleAdderParcela.add(f.getParcela(arrayIndex));
        return doubleAdderParcela.doubleValue();
    }


}
