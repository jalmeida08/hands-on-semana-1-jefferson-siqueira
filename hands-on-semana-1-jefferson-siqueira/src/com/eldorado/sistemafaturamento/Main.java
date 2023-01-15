package com.eldorado.sistemafaturamento;

import com.eldorado.sistemafaturamento.faturamento.ControleFaturamento;
import com.eldorado.sistemafaturamento.nota.ControleNota;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var cf = new ControleFaturamento();
        var listFaturamento = cf.iniciaFaturamento();

        var cn = new ControleNota();
        var listaNota = cn.iniciaLeituraDeNota();




    }
}