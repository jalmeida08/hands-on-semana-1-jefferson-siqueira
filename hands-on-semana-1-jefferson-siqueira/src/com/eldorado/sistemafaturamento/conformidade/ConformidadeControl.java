package com.eldorado.sistemafaturamento.conformidade;

import com.eldorado.sistemafaturamento.nota.Nota;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConformidadeControl {

    private final ConformidadeService conformidadeService;
    private final FileManagerConformidade fileManagerConformidade;

    public ConformidadeControl() {
        this.conformidadeService = new ConformidadeService();
        this.fileManagerConformidade = new FileManagerConformidade();
    }

    public void generateReportWithConformidade(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Nota> listaNota) throws IOException {
        List<DadoNotaFaturamento> listCompanyWithConformidade =
                conformidadeService.returnListWithConfirmidade(listCompanyGroupForYearAndMonthAndSumParcela,listaNota);
        this.fileManagerConformidade.geraArquivoComConformidade(listCompanyWithConformidade);
    }
}
