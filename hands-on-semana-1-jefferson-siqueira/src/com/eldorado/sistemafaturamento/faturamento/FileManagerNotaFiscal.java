package com.eldorado.sistemafaturamento.faturamento;

import com.eldorado.sistemafaturamento.file.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileManagerNotaFiscal implements FileManager {

    private static String RESOURCE = "./resource/faturamento";

    protected void readNotaFiscal() throws IOException {
        var bf = carregaArquivo(RESOURCE + "/faturamento.txt");
        var line = bf.readLine();
        List<String> listCompanyWithError = new ArrayList<>();
        while(line != null) {
            String vetorFaturamento[] = line.split(";");
            try {

                Faturamento faturamento = montaObjeto(vetorFaturamento);
                System.out.println(faturamento.toString());
                line = bf.readLine();
            } catch (NumberFormatException e) {
                System.out.println("ERRO : " + e.getMessage());
                listCompanyWithError.add(vetorFaturamento[0]);
                line = bf.readLine();
            }
        }
        System.out.println("ERRO: " + listCompanyWithError.toString());
    }

    private void relatorioDeErro() {
    }

    private Faturamento montaObjeto(String[] vetorFaturamento) {

        return new FaturamentoBuilder()
                .company(vetorFaturamento[0])
                .mes(vetorFaturamento[1])
                .ano(vetorFaturamento[2])
                .listaParcela(vetorFaturamento[3], vetorFaturamento[4])
                .listaParcela(vetorFaturamento[5], vetorFaturamento[6])
                .listaParcela(vetorFaturamento[7], vetorFaturamento[8])
                .build();
    }

    @Override
    public void closeRead(BufferedReader bf) throws IOException {
        bf.close();
    }
}
