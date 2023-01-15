package com.eldorado.sistemafaturamento.conformidade;

import com.eldorado.sistemafaturamento.file.FileManager;
import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

class FileManagerConformidade implements FileManager {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static String RESOURCE = "./resource/relatorio-conformidade";

    protected void geraArquivoComConformidade(List<DadoNotaFaturamento> listaCompanComConformidade) throws IOException {
        BufferedWriter bfw = criaRelatorio(RESOURCE+"/com-comformidade.txt");
        bfw.write("company;ano;mes;valorNota;valorTotalFaturamento\n");
        listaCompanComConformidade.stream()
                .forEach( item -> {
                    try {
                        bfw.write(item.toString());
                        bfw.write("\n");
                    } catch (IOException e) {
                        LOGGER.info("ERRO AO EXECUTAR ESCRITA DA COMPANY: " + item.getCompany());
                    }
                });
        closeWriter(bfw);
    }
}
