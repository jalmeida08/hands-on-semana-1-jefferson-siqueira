package com.eldorado.sistemafaturamento.faturamento;

import com.eldorado.sistemafaturamento.file.FileManager;
import com.sun.tools.javac.Main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

class FaturamentoFileManager implements FileManager {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static String RESOURCE_FATURAMENTO = "./resource/faturamento/";
    private static String RESOURCE_RELATORIO = "./resource/relatorio/";

    protected List<Faturamento> readFaturamento() throws IOException {
        var br = carregaArquivo(RESOURCE_FATURAMENTO + "faturamento.txt");
        var line = br.readLine();
        List<Faturamento> listFaturamento = new ArrayList<>();

        while(line != null) {
            String vetorFaturamento[] = line.split(";");
            try {
                listFaturamento.add(generateObjeto(vetorFaturamento));
                line = br.readLine();
            } catch (NumberFormatException e) {
                LOGGER.info("ERRO :: " + e.getMessage());
                line = br.readLine();
            }
        }
        closeRead(br);
        return listFaturamento;
    }


    private Faturamento generateObjeto(String[] vetorFaturamento) {

        return new FaturamentoBuilder()
                .company(vetorFaturamento[0])
                .mes(vetorFaturamento[1])
                .ano(vetorFaturamento[2])
                .listaParcela(vetorFaturamento[3], vetorFaturamento[4])
                .listaParcela(vetorFaturamento[5], vetorFaturamento[6])
                .listaParcela(vetorFaturamento[7], vetorFaturamento[8])
                .build();
    }




    public void reportGenerateCompanyGroupForYearAndMonthAndSumParcela(Map<Integer, Map<Integer, Map<String, Double>>> list, final String fileName, final String heading) throws IOException {
        BufferedWriter bfw = criaRelatorio(RESOURCE_RELATORIO + fileName);
        bfw.write(heading+"\n");
        list.values().stream()
                .map(ano -> ano.values())
                .forEach( item -> {
                    writeTextFile(bfw, item.toString());
                });
        closeWriter(bfw);
    }

    public void reportGenerateCompanyGroupForYearAndSumParcelaForCompany(Map<Integer, Map<String, Double[]>> list, final String fileName, final String heading) throws IOException {
        BufferedWriter bfw = criaRelatorio(RESOURCE_RELATORIO + fileName);
        bfw.write(heading+"\n");
        list.values().stream()
                .map(ano -> ano.values())
                .forEach( item -> {
                    item.stream().forEach( a -> {
                        writeTextFile(bfw,a.toString());
                    });
                });
        closeWriter(bfw);
    }
    public void reportGenerateFaturamentoForYearAndCompany(Map<Integer, Map<String, Double>> list, final String fileName, final String heading) throws IOException {
        BufferedWriter bfw = criaRelatorio(RESOURCE_RELATORIO + fileName);
        bfw.write(heading+"\n");
        list.values().stream()
                .map(ano -> ano.values())
                .forEach( item -> {
                    writeTextFile(bfw, item.toString());
                });
        closeWriter(bfw);
    }

    private void writeTextFile(BufferedWriter bfw, String item) {
        try {
            bfw.write(item);
            bfw.write("\n");
        } catch (IOException e) {
            LOGGER.info("ERRO AO EXECUTAR ESCRITA do arquivo ");
        }
    }

}
