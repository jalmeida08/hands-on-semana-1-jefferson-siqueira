package com.eldorado.sistemafaturamento.faturamento;

import java.io.IOException;
import java.util.List;

public class ControleFaturamento {

    public List<Faturamento> iniciaFaturamento() throws IOException {
        var lstFaturamento = new FileManagerFaturamento().readFaturamento();
        new ServiceFaturamento().calculaFaturamento(lstFaturamento);
        return lstFaturamento;
    }
}
