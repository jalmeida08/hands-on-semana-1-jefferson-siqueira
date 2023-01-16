package com.eldorado.sistemafaturamento;

import com.eldorado.sistemafaturamento.programa.Inicio;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var ini = new Inicio();
        ini.interacaoComUsuario();
    }
}