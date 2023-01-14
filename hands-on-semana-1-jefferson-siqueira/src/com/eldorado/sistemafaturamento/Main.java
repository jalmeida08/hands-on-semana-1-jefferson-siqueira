package com.eldorado.sistemafaturamento;

import com.eldorado.sistemafaturamento.faturamento.ControleFaturamento;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var cf = new ControleFaturamento();
        cf.iniciaFaturamento();
    }
}