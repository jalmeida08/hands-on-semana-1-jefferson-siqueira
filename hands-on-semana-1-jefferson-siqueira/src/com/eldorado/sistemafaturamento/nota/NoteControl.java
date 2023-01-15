package com.eldorado.sistemafaturamento.nota;

import java.io.IOException;
import java.util.List;

public class NoteControl {

    public List<Note> startReadTheNote() throws IOException {
        return new FileManagerNota().readNota();
    }

}
