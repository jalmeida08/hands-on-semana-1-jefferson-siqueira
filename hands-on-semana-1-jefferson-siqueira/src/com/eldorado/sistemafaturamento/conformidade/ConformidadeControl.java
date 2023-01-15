package com.eldorado.sistemafaturamento.conformidade;

import com.eldorado.sistemafaturamento.nota.Note;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConformidadeControl {

    private final ConformidadeService conformidadeService;
    private final ConformidadeFileManager conformidadeFileManager;

    public ConformidadeControl() {
        this.conformidadeService = new ConformidadeService();
        this.conformidadeFileManager = new ConformidadeFileManager();
    }

    public void generateReportWithConformidade(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Note> listaNote) throws IOException {
        List<DadoNotaFaturamento> listCompanyWithConformidade =
                conformidadeService.returnListWithConfirmidade(listCompanyGroupForYearAndMonthAndSumParcela, listaNote);
        List<DadoNotaFaturamento> listCompanyWithoutConformidade =
                conformidadeService.returnListWithoutConfirmidade(listCompanyGroupForYearAndMonthAndSumParcela, listaNote);

        this.conformidadeFileManager.geraRelatorioConformidade(listCompanyWithConformidade, "com-comformidade.txt");
        this.conformidadeFileManager.geraRelatorioConformidade(listCompanyWithoutConformidade, "sem-comformidade.txt");
    }

    public void generateReportWithConformidadeForYear(Map<Integer, Map<Integer, Map<String, Double>>> listCompanyGroupForYearAndMonthAndSumParcela, List<Note> listaNote, int year) throws IOException {
        List<DadoNotaFaturamento> listCompanyWithConformidade =
                conformidadeService.returnListWithConfirmidadeForYear(listCompanyGroupForYearAndMonthAndSumParcela, listaNote, year);
        List<DadoNotaFaturamento> listCompanyWithoutConformidade =
                conformidadeService.returnListWithoutConfirmidadeForYear(listCompanyGroupForYearAndMonthAndSumParcela, listaNote, year);

        this.conformidadeFileManager.geraRelatorioConformidade(listCompanyWithConformidade, "com-comformidade-"+year+".txt");
        this.conformidadeFileManager.geraRelatorioConformidade(listCompanyWithoutConformidade, "sem-comformidade-"+year+".txt");
    }
}
