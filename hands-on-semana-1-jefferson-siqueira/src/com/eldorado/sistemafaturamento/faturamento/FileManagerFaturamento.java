package com.eldorado.sistemafaturamento.faturamento;

import com.eldorado.sistemafaturamento.file.FileManager;
import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class FileManagerFaturamento implements FileManager {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static String RESOURCE = "./resource/faturamento";

    protected List<Faturamento> readFaturamento() throws IOException {
        var bf = carregaArquivo(RESOURCE + "/faturamento.txt");
        var line = bf.readLine();
        List<String> listCompanyWithError = new ArrayList<>();
        List<Faturamento> listaFaturamento = new ArrayList<Faturamento>();

        while(line != null) {
            String vetorFaturamento[] = line.split(";");
            try {
                listaFaturamento.add(montaObjeto(vetorFaturamento));
                line = bf.readLine();
            } catch (NumberFormatException e) {
                LOGGER.info("ERRO : " + e.getMessage());
                listCompanyWithError.add(vetorFaturamento[0]);
                line = bf.readLine();
            }
        }
        return listaFaturamento;
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
