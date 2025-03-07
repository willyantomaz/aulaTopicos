package com.aula.livros;

public enum Status {
    DISPONÍVEL(0),
    EM_EMPRESTIMO(1),
    RESERVADO(2);

    public int status;

    Status(int status) {
        this.status = status;
    }
}
