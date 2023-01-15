package com.eldorado.sistemafaturamento;

import com.eldorado.sistemafaturamento.conformidade.ConformidadeControl;
import com.eldorado.sistemafaturamento.faturamento.ControleFaturamento;
import com.eldorado.sistemafaturamento.nota.NoteControl;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        var answerReportForYear = "N";
        var yearSpecificForReport = 0;
        System.out.println(" =============================================== ");
        System.out.println(" Wolcome to system for generete report faturamento ");
        System.out.println(" =============================================== ");

        System.out.println("Wish you generate report for specific year?");
        System.out.println("(y) for yes or (n) for no");
        answerReportForYear = scanner.nextLine();

        if("Y".equals(answerReportForYear.toUpperCase())){
            System.out.println("Informe the year:");
            yearSpecificForReport = Integer.parseInt(scanner.nextLine());
        }

        var cf = new ControleFaturamento();
        var cn = new NoteControl();

        var listFaturamentoForYearAndCompany = cf.listFaturamentoForYearAndCompany();
        var listCompanyGroupForYearAndSumParcelaForCompany = cf.companyGroupForYearAndSumParcelaForCompany();
        var listCompanyGroupForYearAndMonthAndSumParcela = cf.companyGroupForYearAndMonthAndSumParcela();


        var listaNota = cn.startReadTheNote();

        var conformidadeControl = new ConformidadeControl();

        if("Y".equals(answerReportForYear.toUpperCase()) && yearSpecificForReport > 0)
            conformidadeControl.generateReportWithConformidadeForYear(listCompanyGroupForYearAndMonthAndSumParcela, listaNota,yearSpecificForReport);
        else
            conformidadeControl.generateReportWithConformidade(listCompanyGroupForYearAndMonthAndSumParcela, listaNota);
    }
}