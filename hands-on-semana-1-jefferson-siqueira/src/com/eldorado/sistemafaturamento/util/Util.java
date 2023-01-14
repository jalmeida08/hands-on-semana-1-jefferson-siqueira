package com.eldorado.sistemafaturamento.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

    public static LocalDate stringToDate(final String data) {
        var df = DateTimeFormatter.ofPattern("dd/MM/yy");
        return LocalDate.parse(data, df);
    }
}
