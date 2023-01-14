package com.eldorado.sistemafaturamento.faturamento;

import java.io.IOException;

public class ControleFaturamento {

    public void iniciaFaturamento() throws IOException {
        new FileManagerNotaFiscal().readNotaFiscal();

    }
}
