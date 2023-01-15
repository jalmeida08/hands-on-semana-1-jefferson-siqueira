package com.eldorado.sistemafaturamento.conformidade;

import com.eldorado.sistemafaturamento.nota.Nota;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

class ConformidadeService {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    protected List<DadoNotaFaturamento> returnListWithConfirmidade(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Nota> listaNota) {
        List<DadoNotaFaturamento> listWithConformidade = new ArrayList<>();
        listaNota.stream()
                .forEach(n -> {
                    try {
                        double amountCompanyWithYearAndMonth = 0;
                        amountCompanyWithYearAndMonth = listCompanyGroupForYearAndMonthAndSumParcela
                                .get(n.getAno())
                                .get(n.getMes())
                                .get(n.getCompany());

                        if(Double.compare(n.getValor(), amountCompanyWithYearAndMonth) >= 0)
                            listWithConformidade.add(this.retornaObjeto(n,amountCompanyWithYearAndMonth));
                    } catch (NullPointerException e) {
                        LOGGER.info(n.getCompany() +" :: Erro ao gerar relatório de conformidade : " + e.getMessage());
                    }
                });
        return listWithConformidade;
    }

    protected List<DadoNotaFaturamento> returnListWithoutConfirmidade(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Nota> listaNota) {
        List<DadoNotaFaturamento> listWithoutConformidade = new ArrayList<>();
        listaNota.stream()
                .forEach(n -> {
                    var amountCompanyWithYearAndMonth = listCompanyGroupForYearAndMonthAndSumParcela
                            .get(n.getAno())
                            .get(n.getMes())
                            .get(n.getCompany());

                    if(Double.compare(n.getValor(), amountCompanyWithYearAndMonth) < 0)
                        listWithoutConformidade.add(this.retornaObjeto(n,amountCompanyWithYearAndMonth));
                });
        return listWithoutConformidade;
    }
    private DadoNotaFaturamento retornaObjeto(Nota n, Double a) {
        return new DadoNotaFaturamentoBuild()
                .company(n.getCompany())
                .ano(n.getAno())
                .mes(n.getMes())
                .valorNota(n.getValor())
                .valorTotalFaturamento(a)
                .build();
    }
}
