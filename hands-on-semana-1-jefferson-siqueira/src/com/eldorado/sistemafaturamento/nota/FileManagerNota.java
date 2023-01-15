package com.eldorado.sistemafaturamento.nota;

import com.eldorado.sistemafaturamento.file.FileManager;
import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class FileManagerNota implements FileManager {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static String RESOURCE = "./resource/nota";

    protected List<Nota> readNota() throws IOException {
        var bf = carregaArquivo(RESOURCE + "/nota.txt");
        var line = bf.readLine();
        List<Nota> listNota = new ArrayList<>();
        while (line != null) {
            String nota[] = new String[line.split(";").length];
            nota = line.split(";");
            try {
                Nota n = montaObjeto(nota);
                listNota.add(n);
                line = bf.readLine();
            } catch (NumberFormatException e) {
                LOGGER.info("Erro: "+ e.getMessage());
                line = bf.readLine();
            }
        }
        return listNota;
    }

    private Nota montaObjeto(String[] nota) {
        if(nota.length < 6)
            return montaObjetoSemValor(nota);
        return montaObjetoCompleto(nota);
    }

    private Nota montaObjetoSemValor(String[] nota) {
        return new NotaBuilder()
                .company(nota[0])
                .mes(nota[1])
                .ano(nota[2])
                .build();
    }


    private Nota montaObjetoCompleto(String[] nota) {
        return new NotaBuilder()
                .company(nota[0])
                .mes(nota[1])
                .ano(nota[2])
                .valor(nota[3])
                .dataEmissao(nota[4])
                .nota(nota[5])
                .build();
    }

    @Override
    public void closeRead(BufferedReader bf) throws IOException {

    }
}
