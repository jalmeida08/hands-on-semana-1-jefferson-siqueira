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

    protected List<Note> readNota() throws IOException {
        var bf = carregaArquivo(RESOURCE + "/nota.txt");
        var line = bf.readLine();
        List<Note> listNote = new ArrayList<>();
        while (line != null) {
            String nota[] = new String[line.split(";").length];
            nota = line.split(";");
            try {
                Note n = montaObjeto(nota);
                listNote.add(n);
                line = bf.readLine();
            } catch (NumberFormatException e) {
                LOGGER.info("Erro: "+ e.getMessage());
                line = bf.readLine();
            }
        }
        return listNote;
    }

    private Note montaObjeto(String[] nota) {
        if(nota.length < 6)
            return montaObjetoSemValor(nota);
        return montaObjetoCompleto(nota);
    }

    private Note montaObjetoSemValor(String[] nota) {
        return new NotaBuilder()
                .company(nota[0])
                .month(nota[1])
                .year(nota[2])
                .build();
    }


    private Note montaObjetoCompleto(String[] nota) {
        return new NotaBuilder()
                .company(nota[0])
                .month(nota[1])
                .year(nota[2])
                .amount(nota[3])
                .dateEmission(nota[4])
                .note(nota[5])
                .build();
    }

    @Override
    public void closeRead(BufferedReader bf) throws IOException {

    }
}
