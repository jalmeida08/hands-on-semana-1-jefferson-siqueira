package com.eldorado.sistemafaturamento.conformidade;

import com.eldorado.sistemafaturamento.nota.Note;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

class ConformidadeService {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    protected List<DadoNotaFaturamento> returnListWithConfirmidade(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Note> listaNote) {
        List<DadoNotaFaturamento> listWithConformidade = new ArrayList<>();
        listaNote.stream()
                .forEach(n -> {
                    Double amountCompanyWithYearAndMonth = listCompanyGroupForYearAndMonthAndSumParcela
                            .get(n.getYear())
                            .get(n.getMonth())
                            .get(n.getCompany());
                    if(amountCompanyWithYearAndMonth == null)
                        amountCompanyWithYearAndMonth = Double.valueOf(0);

                    if(Double.compare(n.getAmount(), amountCompanyWithYearAndMonth) >= 0)
                        listWithConformidade.add(this.retornaObjeto(n,amountCompanyWithYearAndMonth));

                });
        return listWithConformidade;
    }

    protected List<DadoNotaFaturamento> returnListWithoutConfirmidade(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Note> listaNote) {
        List<DadoNotaFaturamento> listWithoutConformidade = new ArrayList<>();
        listaNote.stream()
                .forEach(n -> {
                        Double amountCompanyWithYearAndMonth = listCompanyGroupForYearAndMonthAndSumParcela
                                .get(n.getYear())
                                .get(n.getMonth())
                                .get(n.getCompany());
                        if(amountCompanyWithYearAndMonth == null)
                            amountCompanyWithYearAndMonth = Double.valueOf(0);

                        if(Double.compare(n.getAmount(), amountCompanyWithYearAndMonth) < 0)
                            listWithoutConformidade.add(this.retornaObjeto(n,amountCompanyWithYearAndMonth));
                });
        return listWithoutConformidade;
    }

    protected List<DadoNotaFaturamento> returnListWithConfirmidadeForYear(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Note> listaNote, int year) {
        List<DadoNotaFaturamento> listWithConformidade = new ArrayList<>();
        listaNote.stream()
                .filter(n -> n.getYear() == year)
                .forEach(n -> {
                    Double amountCompanyWithYearAndMonth = listCompanyGroupForYearAndMonthAndSumParcela
                            .get(n.getYear())
                            .get(n.getMonth())
                            .get(n.getCompany());
                    if(amountCompanyWithYearAndMonth == null)
                        amountCompanyWithYearAndMonth = Double.valueOf(0);

                    if(Double.compare(n.getAmount(), amountCompanyWithYearAndMonth) >= 0)
                        listWithConformidade.add(this.retornaObjeto(n,amountCompanyWithYearAndMonth));

                });
        return listWithConformidade;
    }

    protected List<DadoNotaFaturamento> returnListWithoutConfirmidadeForYear(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Note> listaNote, int year) {
        List<DadoNotaFaturamento> listWithoutConformidade = new ArrayList<>();
        listaNote.stream()
                .filter(n -> n.getYear() == year)
                .forEach(n -> {
                    Double amountCompanyWithYearAndMonth = listCompanyGroupForYearAndMonthAndSumParcela
                            .get(n.getYear())
                            .get(n.getMonth())
                            .get(n.getCompany());
                    if(amountCompanyWithYearAndMonth == null)
                        amountCompanyWithYearAndMonth = Double.valueOf(0);

                    if(Double.compare(n.getAmount(), amountCompanyWithYearAndMonth) < 0)
                        listWithoutConformidade.add(this.retornaObjeto(n,amountCompanyWithYearAndMonth));
                });
        return listWithoutConformidade;
    }
    private DadoNotaFaturamento retornaObjeto(Note n, Double a) {
        return new DadoNotaFaturamentoBuild()
                .company(n.getCompany())
                .ano(n.getYear())
                .mes(n.getMonth())
                .valorNota(n.getAmount())
                .valorTotalFaturamento(a)
                .build();
    }
}
