package com.eldorado.sistemafaturamento.programa;

import com.eldorado.sistemafaturamento.conformidade.ConformidadeControl;
import com.eldorado.sistemafaturamento.faturamento.FaturamentoControl;
import com.eldorado.sistemafaturamento.nota.NoteControl;

import java.io.IOException;
import java.util.Scanner;

public class Inicio {

    private Scanner scanner = new Scanner(System.in);

    public void interacaoComUsuario() throws IOException {
        var faturamentoControl = new FaturamentoControl();
        var noteControl = new NoteControl();
        var conformidadeControl = new ConformidadeControl();
        

        
        System.out.println(" ==================== STARTING ====================");
        System.out.println(" Wolcome to system for generete report faturamento ");
        System.out.println(" ==================== STARTING ====================");

        usingInterfaceReportConformidade(faturamentoControl, noteControl, conformidadeControl);
        listFaturamentoForYearAndCompany(faturamentoControl);
        listCompanyGroupForYearAndSumParcelaForCompany(faturamentoControl);
        listCompanyGroupForYearAndMonthAndSumParcela(faturamentoControl);

        System.out.println(" ==================== FINISHED ====================");
        System.out.println(" Your reports were generated and are resource folder ");
        System.out.println("==================== FINISHED ====================");
    }

    private void usingInterfaceReportConformidade(FaturamentoControl faturamentoControl, NoteControl noteControl, ConformidadeControl conformidadeControl) throws IOException {
        var yearSpecificForReport = 0;
        var answerReportForYear = "N";

        System.out.println("Wish you generate report for specific year?");
        System.out.println("(y) for yes or (n) for no");
        answerReportForYear = scanner.nextLine();

        if("Y".equals(answerReportForYear.toUpperCase())){
            System.out.println("Informe the year:");
            yearSpecificForReport = Integer.parseInt(scanner.nextLine());
        }

        var listaNota = noteControl.startReadTheNote();
        var listCompanyGroupForYearAndMonthAndSumParcela = faturamentoControl.companyGroupForYearAndMonthAndSumParcela();

        if("Y".equals(answerReportForYear.toUpperCase()) && yearSpecificForReport > 0)
            conformidadeControl.generateReportWithConformidadeForYear(listCompanyGroupForYearAndMonthAndSumParcela, listaNota, yearSpecificForReport);
        else
            conformidadeControl.generateReportWithConformidade(listCompanyGroupForYearAndMonthAndSumParcela, listaNota);
    }

    private void listFaturamentoForYearAndCompany(FaturamentoControl faturamentoControl) throws IOException {
        var answerReportForYear = "N";
        System.out.println("Wish you generate a report grouped for year and company?");
        System.out.println("(y) for yes or (n) for no");
        answerReportForYear = scanner.nextLine();

        if("N".equals(answerReportForYear.toUpperCase()))
            return;

        var listFaturamentoForYearAndCompany = faturamentoControl.listFaturamentoForYearAndCompany();
        faturamentoControl.reportGenerateFaturamentoForYearAndCompany(
                listFaturamentoForYearAndCompany,
                "total-faturamento-por-ano-e-compania.txt",
                "ano;company;valorTotal");
    }

    private void listCompanyGroupForYearAndSumParcelaForCompany(FaturamentoControl faturamentoControl) throws IOException {
        var answerReportForYear = "N";
        System.out.println("Wish you generate a report with the parcels sum grouped for year and company?");
        System.out.println("(y) for yes or (n) for no");
        answerReportForYear = scanner.nextLine();

        if("N".equals(answerReportForYear.toUpperCase()))
            return;

        var listCompanyGroupForYearAndSumParcelaForCompany = faturamentoControl.companyGroupForYearAndSumParcelaForCompany();
        faturamentoControl.reportGenerateCompanyGroupForYearAndSumParcelaForCompany(
                listCompanyGroupForYearAndSumParcelaForCompany,
                "total-de-cada-parcela-por-mes-agrupado-por-ano-company.txt",
                "ano;mes;company;total");

    }

    private void listCompanyGroupForYearAndMonthAndSumParcela(FaturamentoControl faturamentoControl) throws IOException {
        var answerReportForYear = "N";
        System.out.println("Wish you generate a report grouped for year and company with sum of parcels for month?");
        System.out.println("(y) for yes or (n) for no");
        answerReportForYear = scanner.nextLine();
        if("N".equals(answerReportForYear.toUpperCase()))
            return;
        var listCompanyGroupForYearAndMonthAndSumParcela = faturamentoControl.companyGroupForYearAndMonthAndSumParcela();
        faturamentoControl.reportGenerateCompanyGroupForYearAndMonthAndSumParcela(
                listCompanyGroupForYearAndMonthAndSumParcela,
                "total-de-cada-mes-parcela-agrupado-por-ano-company.txt",
                "ano;mes;company;total");

    }
}
