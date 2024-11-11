package com.example;

public class Debito {
    private int valor;

    public Debito(int valor) {
        this.valor = valor;
    }

    public boolean verificaDebito() {
        return valor > 0;
    }
}
