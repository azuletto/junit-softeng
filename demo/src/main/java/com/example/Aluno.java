package com.example;

import java.util.List;

public class Aluno {
    private String ra;

    // Construtor
    public Aluno(String ra) {
        if (ra == null || ra.isEmpty()) {
            throw new IllegalArgumentException("RA não pode ser nulo ou vazio.");
        }
        this.ra = ra;
    }

    // Getters e Setters
    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        if (ra == null || ra.isEmpty()) {
            throw new IllegalArgumentException("RA não pode ser nulo ou vazio.");
        }
        this.ra = ra;
    }

    // Verifica se o aluno existe
    public boolean verificarAluno() {
        return !this.ra.equals("10"); // Exemplo: RA "10" representa aluno inválido
    }

    // Verifica se o aluno possui débitos
    public boolean verificaDebito() {
        Debito debito = new Debito(Integer.parseInt(this.ra));
        return debito.verificaDebito();
    }

    // Delegação para emprestar livros
    public boolean emprestar(List<Livro> livros) {
        Emprestimo emprestimo = new Emprestimo();
        return emprestimo.emprestar(livros);
    }
}
