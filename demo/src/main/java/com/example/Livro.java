package com.example;

public class Livro {
    private String titulo;
    private int codigo;
    private boolean disponivel;
	private int prazo;

    public Livro(String titulo, int codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCodigo() {
        return codigo;
    }

	
public void setPrazo(int i) {
    this.prazo = i;
}

public int verPrazo() {
    return this.prazo;
}
}
