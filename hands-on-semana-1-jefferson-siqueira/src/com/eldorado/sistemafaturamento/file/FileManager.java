package com.eldorado.sistemafaturamento.file;

import java.io.*;

public interface FileManager {

    default BufferedReader carregaArquivo(final String path) throws FileNotFoundException {
        return new BufferedReader(new FileReader(path));
    }

    default BufferedWriter criaRelatorio(final String path) throws IOException {
        return new BufferedWriter(new FileWriter(path));
    }

    void closeRead(BufferedReader bf) throws IOException;
}
