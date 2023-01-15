package com.eldorado.sistemafaturamento.nota;

import java.io.IOException;
import java.util.List;

public class ControleNota {

    public List<Nota> iniciaLeituraDeNota() throws IOException {
        return new FileManagerNota().readNota();
    }

}
